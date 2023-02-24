package com.ruoyi.fac.service.impl;

import java.util.Collection;
import java.util.List;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.fac.domain.FacEndDevice;
import com.ruoyi.fac.mapper.FacElectrolyticCellMapper;
import com.ruoyi.fac.domain.FacElectrolyticCell;
import com.ruoyi.fac.service.IFacElectrolyticCellService;

import javax.annotation.PostConstruct;

/**
 * 电解槽管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
@Service
public class FacElectrolyticCellServiceImpl implements IFacElectrolyticCellService 
{
    @Autowired
    private FacElectrolyticCellMapper facElectrolyticCellMapper;


    @Autowired
    private RedisCache redisCache;

    @Override
    public void loadingConfigCache() {
        List<FacElectrolyticCell> facElectrolyticCellList = facElectrolyticCellMapper.selectFacElectrolyticCellList(new FacElectrolyticCell());
        for (FacElectrolyticCell facElectrolyticCell : facElectrolyticCellList)
        {
            redisCache.setCacheObject(getCacheKey(String.valueOf(facElectrolyticCell.getElectrolyticcellId())), facElectrolyticCell);
        }
    }

    @Override
    public void clearConfigCache() {
        Collection<String> keys = redisCache.keys(CacheConstants.ELECELL_INFO_KEY + "*");
        redisCache.deleteObject(keys);
    }

    @Override
    public void resetConfigCache() {
        clearConfigCache();
        loadingConfigCache();
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(String configKey)
    {
        return CacheConstants.ELECELL_INFO_KEY + configKey;
    }
    /**
     * 项目启动时，把信息表存到缓存
     */
    @PostConstruct
    public void init()
    {
//        loadingConfigCache();
        resetConfigCache();
    }





    /**
     * 查询电解槽管理
     * 
     * @param electrolyticcellId 电解槽管理主键
     * @return 电解槽管理
     */
    @Override
    public FacElectrolyticCell selectFacElectrolyticCellByElectrolyticcellId(Long electrolyticcellId)
    {
        return facElectrolyticCellMapper.selectFacElectrolyticCellByElectrolyticcellId(electrolyticcellId);
    }

    /**
     * 查询电解槽管理列表
     * 
     * @param facElectrolyticCell 电解槽管理
     * @return 电解槽管理
     */
    @Override
    public List<FacElectrolyticCell> selectFacElectrolyticCellList(FacElectrolyticCell facElectrolyticCell)
    {
        return facElectrolyticCellMapper.selectFacElectrolyticCellList(facElectrolyticCell);
    }

    /**
     * 新增电解槽管理
     * 
     * @param facElectrolyticCell 电解槽管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertFacElectrolyticCell(FacElectrolyticCell facElectrolyticCell)
    {
        int rows = facElectrolyticCellMapper.insertFacElectrolyticCell(facElectrolyticCell);
        insertFacEndDevice(facElectrolyticCell);
        return rows;
    }

    /**
     * 修改电解槽管理
     * 
     * @param facElectrolyticCell 电解槽管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateFacElectrolyticCell(FacElectrolyticCell facElectrolyticCell)
    {
        facElectrolyticCellMapper.deleteFacEndDeviceByElectrolyticellId(facElectrolyticCell.getElectrolyticcellId());
        insertFacEndDevice(facElectrolyticCell);
        return facElectrolyticCellMapper.updateFacElectrolyticCell(facElectrolyticCell);
    }

    /**
     * 批量删除电解槽管理
     * 
     * @param electrolyticcellIds 需要删除的电解槽管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacElectrolyticCellByElectrolyticcellIds(Long[] electrolyticcellIds)
    {
        facElectrolyticCellMapper.deleteFacEndDeviceByElectrolyticellIds(electrolyticcellIds);
        return facElectrolyticCellMapper.deleteFacElectrolyticCellByElectrolyticcellIds(electrolyticcellIds);
    }

    /**
     * 删除电解槽管理信息
     * 
     * @param electrolyticcellId 电解槽管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacElectrolyticCellByElectrolyticcellId(Long electrolyticcellId)
    {
        facElectrolyticCellMapper.deleteFacEndDeviceByElectrolyticellId(electrolyticcellId);
        return facElectrolyticCellMapper.deleteFacElectrolyticCellByElectrolyticcellId(electrolyticcellId);
    }

    /**
     * 新增设备管理信息
     * 
     * @param facElectrolyticCell 电解槽管理对象
     */
    public void insertFacEndDevice(FacElectrolyticCell facElectrolyticCell)
    {
        List<FacEndDevice> facEndDeviceList = facElectrolyticCell.getFacEndDeviceList();
        Long electrolyticcellId = facElectrolyticCell.getElectrolyticcellId();
        if (StringUtils.isNotNull(facEndDeviceList))
        {
            List<FacEndDevice> list = new ArrayList<FacEndDevice>();
            for (FacEndDevice facEndDevice : facEndDeviceList)
            {
                facEndDevice.setElectrolyticellId(electrolyticcellId);
                list.add(facEndDevice);
            }
            if (list.size() > 0)
            {
                facElectrolyticCellMapper.batchFacEndDevice(list);
            }
        }
    }
}

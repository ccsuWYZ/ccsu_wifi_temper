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
import com.ruoyi.fac.domain.FacElectrolyticCell;
import com.ruoyi.fac.mapper.FacWorkshopMapper;
import com.ruoyi.fac.domain.FacWorkshop;
import com.ruoyi.fac.service.IFacWorkshopService;

import javax.annotation.PostConstruct;

/**
 * 生产车间Service业务层处理
 * 
 * @author ccsu
 * @date 2022-11-22
 */
@Service
public class FacWorkshopServiceImpl implements IFacWorkshopService 
{
    @Autowired
    private FacWorkshopMapper facWorkshopMapper;

    @Autowired
    private RedisCache redisCache;
    @Override
    public void loadingConfigCache() {
        List<FacWorkshop> facWorkshopList = facWorkshopMapper.selectFacWorkshopList(new FacWorkshop());
        for (FacWorkshop facWorkshop : facWorkshopList)
        {
            redisCache.setCacheObject(getCacheKey(String.valueOf(facWorkshop.getWorkshopId())), facWorkshop);
        }
    }

    @Override
    public void clearConfigCache() {
        Collection<String> keys = redisCache.keys(CacheConstants.WORKSHOP_INFO_KEY + "*");
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
        return CacheConstants.WORKSHOP_INFO_KEY + configKey;
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
     * 查询生产车间
     * 
     * @param workshopId 生产车间主键
     * @return 生产车间
     */
    @Override
    public FacWorkshop selectFacWorkshopByWorkshopId(Long workshopId)
    {
        return facWorkshopMapper.selectFacWorkshopByWorkshopId(workshopId);
    }

    /**
     * 查询生产车间列表
     * 
     * @param facWorkshop 生产车间
     * @return 生产车间
     */
    @Override
    public List<FacWorkshop> selectFacWorkshopList(FacWorkshop facWorkshop)
    {
        return facWorkshopMapper.selectFacWorkshopList(facWorkshop);
    }

    /**
     * 新增生产车间
     * 
     * @param facWorkshop 生产车间
     * @return 结果
     */
    @Transactional
    @Override
    public int insertFacWorkshop(FacWorkshop facWorkshop)
    {
        int rows = facWorkshopMapper.insertFacWorkshop(facWorkshop);
        insertFacElectrolyticCell(facWorkshop);
        return rows;
    }

    /**
     * 修改生产车间
     * 
     * @param facWorkshop 生产车间
     * @return 结果
     */
    @Transactional
    @Override
    public int updateFacWorkshop(FacWorkshop facWorkshop)
    {
        facWorkshopMapper.deleteFacElectrolyticCellByWorkshopId(facWorkshop.getWorkshopId());
        insertFacElectrolyticCell(facWorkshop);
        return facWorkshopMapper.updateFacWorkshop(facWorkshop);
    }

    /**
     * 批量删除生产车间
     * 
     * @param workshopIds 需要删除的生产车间主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacWorkshopByWorkshopIds(Long[] workshopIds)
    {
        facWorkshopMapper.deleteFacElectrolyticCellByWorkshopIds(workshopIds);
        return facWorkshopMapper.deleteFacWorkshopByWorkshopIds(workshopIds);
    }

    /**
     * 删除生产车间信息
     * 
     * @param workshopId 生产车间主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacWorkshopByWorkshopId(Long workshopId)
    {
        facWorkshopMapper.deleteFacElectrolyticCellByWorkshopId(workshopId);
        return facWorkshopMapper.deleteFacWorkshopByWorkshopId(workshopId);
    }

    /**
     * 新增电解槽管理信息
     * 
     * @param facWorkshop 生产车间对象
     */
    public void insertFacElectrolyticCell(FacWorkshop facWorkshop)
    {
        List<FacElectrolyticCell> facElectrolyticCellList = facWorkshop.getFacElectrolyticCellList();
        Long workshopId = facWorkshop.getWorkshopId();
        if (StringUtils.isNotNull(facElectrolyticCellList))
        {
            List<FacElectrolyticCell> list = new ArrayList<FacElectrolyticCell>();
            for (FacElectrolyticCell facElectrolyticCell : facElectrolyticCellList)
            {
                facElectrolyticCell.setWorkshopId(workshopId);
                list.add(facElectrolyticCell);
            }
            if (list.size() > 0)
            {
                facWorkshopMapper.batchFacElectrolyticCell(list);
            }
        }
    }
}

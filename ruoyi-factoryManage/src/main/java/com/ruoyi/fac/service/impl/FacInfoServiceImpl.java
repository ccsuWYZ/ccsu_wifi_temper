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
import com.ruoyi.fac.domain.FacWorkshop;
import com.ruoyi.fac.mapper.FacInfoMapper;
import com.ruoyi.fac.domain.FacInfo;
import com.ruoyi.fac.service.IFacInfoService;

import javax.annotation.PostConstruct;

/**
 * 工厂管理Service业务层处理
 * 
 * @author ccsu
 * @date 2022-11-22
 */
@Service
public class FacInfoServiceImpl implements IFacInfoService 
{
    @Autowired
    private FacInfoMapper facInfoMapper;
    @Autowired
    private RedisCache redisCache;
    @Override
    public void loadingConfigCache() {
        List<FacInfo> facInfoList = facInfoMapper.selectFacInfoList(new FacInfo());
        for (FacInfo facInfo : facInfoList)
        {
            redisCache.setCacheObject(getCacheKey(String.valueOf(facInfo.getFactoryId())), facInfo);
        }
    }

    @Override
    public void clearConfigCache() {
        Collection<String> keys = redisCache.keys(CacheConstants.FAC_INFO_KEY + "*");
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
        return CacheConstants.FAC_INFO_KEY + configKey;
    }
    /**
     * 项目启动时，把工厂信息表存到缓存
     */
    @PostConstruct
    public void init()
    {
//        loadingConfigCache();
        resetConfigCache();
    }
    /**
     * 查询工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 工厂管理
     */
    @Override
    public FacInfo selectFacInfoByFactoryId(Long factoryId)
    {
        return facInfoMapper.selectFacInfoByFactoryId(factoryId);
    }

    /**
     * 查询工厂管理列表
     * 
     * @param facInfo 工厂管理
     * @return 工厂管理
     */
    @Override
    public List<FacInfo> selectFacInfoList(FacInfo facInfo)
    {
        return facInfoMapper.selectFacInfoList(facInfo);
    }

    /**
     * 新增工厂管理
     * 
     * @param facInfo 工厂管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertFacInfo(FacInfo facInfo)
    {
        int rows = facInfoMapper.insertFacInfo(facInfo);
        insertFacWorkshop(facInfo);
        return rows;
    }

    /**
     * 修改工厂管理
     * 
     * @param facInfo 工厂管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateFacInfo(FacInfo facInfo)
    {
        facInfoMapper.deleteFacWorkshopByFactoryId(facInfo.getFactoryId());
        insertFacWorkshop(facInfo);
        return facInfoMapper.updateFacInfo(facInfo);
    }

    /**
     * 批量删除工厂管理
     * 
     * @param factoryIds 需要删除的工厂管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacInfoByFactoryIds(Long[] factoryIds)
    {
        facInfoMapper.deleteFacWorkshopByFactoryIds(factoryIds);
        return facInfoMapper.deleteFacInfoByFactoryIds(factoryIds);
    }

    /**
     * 删除工厂管理信息
     * 
     * @param factoryId 工厂管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacInfoByFactoryId(Long factoryId)
    {
        facInfoMapper.deleteFacWorkshopByFactoryId(factoryId);
        return facInfoMapper.deleteFacInfoByFactoryId(factoryId);
    }

    /**
     * 新增生产车间信息
     * 
     * @param facInfo 工厂管理对象
     */
    public void insertFacWorkshop(FacInfo facInfo)
    {
        List<FacWorkshop> facWorkshopList = facInfo.getFacWorkshopList();
        Long factoryId = facInfo.getFactoryId();
        if (StringUtils.isNotNull(facWorkshopList))
        {
            List<FacWorkshop> list = new ArrayList<FacWorkshop>();
            for (FacWorkshop facWorkshop : facWorkshopList)
            {
                facWorkshop.setFactoryId(factoryId);
                list.add(facWorkshop);
            }
            if (list.size() > 0)
            {
                facInfoMapper.batchFacWorkshop(list);
            }
        }
    }
}

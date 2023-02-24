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
import com.ruoyi.fac.domain.FacThermocouple;
import com.ruoyi.fac.mapper.FacEndDeviceMapper;
import com.ruoyi.fac.domain.FacEndDevice;
import com.ruoyi.fac.service.IFacEndDeviceService;

import javax.annotation.PostConstruct;

/**
 * 设备管理Service业务层处理
 * 
 * @author ccsu
 * @date 2022-11-22
 */
@Service
public class FacEndDeviceServiceImpl implements IFacEndDeviceService 
{
    @Autowired
    private FacEndDeviceMapper facEndDeviceMapper;

    @Autowired
    private RedisCache redisCache;
    @Override
    public void loadingConfigCache() {
        List<FacEndDevice> facEndDeviceList = facEndDeviceMapper.selectFacEndDeviceList(new FacEndDevice());
        for (FacEndDevice facEndDevice : facEndDeviceList)
        {
            redisCache.setCacheObject(getCacheKey(String.valueOf(facEndDevice.getDeviceId())), facEndDevice);
        }
    }

    @Override
    public void clearConfigCache() {
        Collection<String> keys = redisCache.keys(CacheConstants.DEVICE_INFO_KEY + "*");
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
        return CacheConstants.DEVICE_INFO_KEY + configKey;
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
     * 查询设备管理
     * 
     * @param deviceId 设备管理主键
     * @return 设备管理
     */
    @Override
    public FacEndDevice selectFacEndDeviceByDeviceId(String deviceId)
    {
        return facEndDeviceMapper.selectFacEndDeviceByDeviceId(deviceId);
    }

    /**
     * 查询设备管理列表
     * 
     * @param facEndDevice 设备管理
     * @return 设备管理
     */
    @Override
    public List<FacEndDevice> selectFacEndDeviceList(FacEndDevice facEndDevice)
    {
        return facEndDeviceMapper.selectFacEndDeviceList(facEndDevice);
    }

    /**
     * 新增设备管理
     * 
     * @param facEndDevice 设备管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertFacEndDevice(FacEndDevice facEndDevice)
    {
        int rows = facEndDeviceMapper.insertFacEndDevice(facEndDevice);
        insertFacThermocouple(facEndDevice);
        return rows;
    }

    /**
     * 修改设备管理
     * 
     * @param facEndDevice 设备管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateFacEndDevice(FacEndDevice facEndDevice)
    {
        facEndDeviceMapper.deleteFacThermocoupleByEndDeviceId(facEndDevice.getDeviceId());
        insertFacThermocouple(facEndDevice);
        return facEndDeviceMapper.updateFacEndDevice(facEndDevice);
    }

    /**
     * 批量删除设备管理
     * 
     * @param deviceIds 需要删除的设备管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacEndDeviceByDeviceIds(String[] deviceIds)
    {
        facEndDeviceMapper.deleteFacThermocoupleByEndDeviceIds(deviceIds);
        return facEndDeviceMapper.deleteFacEndDeviceByDeviceIds(deviceIds);
    }

    /**
     * 删除设备管理信息
     * 
     * @param deviceId 设备管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteFacEndDeviceByDeviceId(String deviceId)
    {
        facEndDeviceMapper.deleteFacThermocoupleByEndDeviceId(deviceId);
        return facEndDeviceMapper.deleteFacEndDeviceByDeviceId(deviceId);
    }

    /**
     * 新增热电偶信息
     * 
     * @param facEndDevice 设备管理对象
     */
    public void insertFacThermocouple(FacEndDevice facEndDevice)
    {
        List<FacThermocouple> facThermocoupleList = facEndDevice.getFacThermocoupleList();
        String deviceId = facEndDevice.getDeviceId();
        if (StringUtils.isNotNull(facThermocoupleList))
        {
            List<FacThermocouple> list = new ArrayList<FacThermocouple>();
            for (FacThermocouple facThermocouple : facThermocoupleList)
            {
                facThermocouple.setEndDeviceId(deviceId);
                list.add(facThermocouple);
            }
            if (list.size() > 0)
            {
                facEndDeviceMapper.batchFacThermocouple(list);
            }
        }
    }
}

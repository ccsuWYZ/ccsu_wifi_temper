package com.ruoyi.fac.service.impl;

import java.util.Collection;
import java.util.List;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.fac.domain.FacEndDevice;
import com.ruoyi.fac.mapper.FacEndDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fac.mapper.FacThermocoupleMapper;
import com.ruoyi.fac.domain.FacThermocouple;
import com.ruoyi.fac.service.IFacThermocoupleService;

import javax.annotation.PostConstruct;

/**
 * 热电偶Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
@Service
public class FacThermocoupleServiceImpl implements IFacThermocoupleService 
{
    @Autowired
    private FacThermocoupleMapper facThermocoupleMapper;
    @Autowired
    private FacEndDeviceMapper facEndDeviceMapper;


    @Autowired
    private RedisCache redisCache;
    @Override
    public void loadingConfigCache() {
        List<FacEndDevice> facEndDeviceList = facEndDeviceMapper.selectFacEndDeviceList(new FacEndDevice());
//        List<FacThermocouple> facEndDeviceList = facThermocoupleMapper.selectFacThermocoupleList(new FacThermocouple());
        for (FacEndDevice facEndDevice : facEndDeviceList)
        {
//            redisCache.setCacheObject(getCacheKey(String.valueOf(facThermocouple.getEndDeviceId())+":"+facThermocouple.getThermocoupleId()), facThermocouple);

        List<FacThermocouple> facThermocoupleList=facThermocoupleMapper.selectFacThermocoupleByEndDeviceId(facEndDevice.getDeviceId());
            redisCache.setCacheList(getCacheKey(facEndDevice.getDeviceId()),facThermocoupleList);


        }
    }

    @Override
    public void clearConfigCache() {
        Collection<String> keys = redisCache.keys(CacheConstants.THERMOCOUPLE_INFO_KEY + "*");
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
        return CacheConstants.THERMOCOUPLE_INFO_KEY + configKey;
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
     * 查询热电偶
     * 
     * @param thermocoupleId 热电偶主键
     * @return 热电偶
     */
    @Override
    public FacThermocouple selectFacThermocoupleByThermocoupleId(String thermocoupleId)
    {
        return facThermocoupleMapper.selectFacThermocoupleByThermocoupleId(thermocoupleId);
    }

    /**
     * 查询热电偶列表
     * 
     * @param facThermocouple 热电偶
     * @return 热电偶
     */
    @Override
    public List<FacThermocouple> selectFacThermocoupleList(FacThermocouple facThermocouple)
    {
        return facThermocoupleMapper.selectFacThermocoupleList(facThermocouple);
    }

    /**
     * 新增热电偶
     * 
     * @param facThermocouple 热电偶
     * @return 结果
     */
    @Override
    public int insertFacThermocouple(FacThermocouple facThermocouple)
    {
        return facThermocoupleMapper.insertFacThermocouple(facThermocouple);
    }

    /**
     * 修改热电偶
     * 
     * @param facThermocouple 热电偶
     * @return 结果
     */
    @Override
    public int updateFacThermocouple(FacThermocouple facThermocouple)
    {
        return facThermocoupleMapper.updateFacThermocouple(facThermocouple);
    }

    /**
     * 批量删除热电偶
     * 
     * @param thermocoupleIds 需要删除的热电偶主键
     * @return 结果
     */
    @Override
    public int deleteFacThermocoupleByThermocoupleIds(String[] thermocoupleIds)
    {
        return facThermocoupleMapper.deleteFacThermocoupleByThermocoupleIds(thermocoupleIds);
    }

    /**
     * 删除热电偶信息
     * 
     * @param thermocoupleId 热电偶主键
     * @return 结果
     */
    @Override
    public int deleteFacThermocoupleByThermocoupleId(String thermocoupleId)
    {
        return facThermocoupleMapper.deleteFacThermocoupleByThermocoupleId(thermocoupleId);
    }
}

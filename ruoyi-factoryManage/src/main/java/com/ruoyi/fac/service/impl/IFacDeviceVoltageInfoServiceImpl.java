package com.ruoyi.fac.service.impl;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.domain.FacEndDevice;
import com.ruoyi.fac.mapper.FacDeviceMetaSensorDataMapper;
import com.ruoyi.fac.mapper.FacEndDeviceMapper;
import com.ruoyi.fac.service.IFacDeviceVoltageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @date 2023-01-13 11:41:58
 * @description
 */
@Service
public class IFacDeviceVoltageInfoServiceImpl implements IFacDeviceVoltageInfoService {
    @Autowired
    private FacDeviceMetaSensorDataMapper facDeviceMetaSensorDataMapper;
    @Autowired
    private FacEndDeviceMapper facEndDeviceMapper;
    @Autowired
    private RedisCache redisCache;
    @Override
    public AjaxResult getDeviceVoltageInfo(FacDeviceMetaSensorData facDeviceMetaSensorData) {
        List<FacDeviceMetaSensorData> facDeviceMetaVolList = facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
        List<FacEndDevice> facEndDeviceList = facEndDeviceMapper.selectFacEndDeviceList(new FacEndDevice("1"));
        Double vol1 = Double.valueOf(redisCache.getCacheObject(CacheConstants.SYS_CONFIG_KEY + "fac.vol.vol1"));
        Double vol2 = Double.valueOf(redisCache.getCacheObject(CacheConstants.SYS_CONFIG_KEY + "fac.vol.vol2"));
        Double vol;
        HashSet<String> warningEndDeviceId = new HashSet<>();
        HashSet<String> errorEndDeviceId = new HashSet<>();
        HashSet<String> normalEndDeviceId = new HashSet<>();
        HashSet<String> allEndDeviceId = new HashSet<>();
        System.out.println(facDeviceMetaVolList.size());
        for (FacDeviceMetaSensorData facDeviceMetaVolData : facDeviceMetaVolList) {
            if ("null".equals(facDeviceMetaVolData.getValue()))continue;
            vol = Double.valueOf(facDeviceMetaVolData.getValue());
            if (vol > vol1 && vol < vol2) {
                warningEndDeviceId.add(facDeviceMetaVolData.getDeviceId());
            }
            if (vol <= vol1) {
                errorEndDeviceId.add(facDeviceMetaVolData.getDeviceId());
            }
        }
        for (FacEndDevice facEndDevice : facEndDeviceList) {
            allEndDeviceId.add(facEndDevice.getDeviceId());
        }
        Map<String, Object> res = new HashMap<>();
        normalEndDeviceId.addAll(allEndDeviceId);
        for (String errorE:errorEndDeviceId){
            for (String warnE:warningEndDeviceId){
                if (errorE.equals(warnE) ){
                    warningEndDeviceId.remove(warnE);
                }
            }
        }
        normalEndDeviceId.removeAll(errorEndDeviceId);
        normalEndDeviceId.removeAll(warningEndDeviceId);
        System.out.println("故障：");
        System.out.println(errorEndDeviceId);
        System.out.println("预警：");
        System.out.println(warningEndDeviceId);
        System.out.println("正常：");
        System.out.println(normalEndDeviceId);
        res.put("all", allEndDeviceId);
        res.put("normal", normalEndDeviceId);
        res.put("error", errorEndDeviceId);
        res.put("warning", warningEndDeviceId);
        return new AjaxResult(200, "返回的终端电压信息", res);
    }
}

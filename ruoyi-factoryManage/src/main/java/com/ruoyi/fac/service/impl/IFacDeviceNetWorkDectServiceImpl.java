package com.ruoyi.fac.service.impl;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.domain.FacEndDevice;
import com.ruoyi.fac.mapper.FacDeviceMetaSensorDataMapper;
import com.ruoyi.fac.mapper.FacEndDeviceMapper;
import com.ruoyi.fac.service.IFacDeviceNetWorkDectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author lee
 * @date 2023-01-13 14:17:21
 * @description
 */
@Service
public class IFacDeviceNetWorkDectServiceImpl implements IFacDeviceNetWorkDectService {
    @Autowired
    private FacDeviceMetaSensorDataMapper facDeviceMetaSensorDataMapper;
    @Autowired
    private FacEndDeviceMapper facEndDeviceMapper;
//    @Autowired
//    private RedisCache redisCache;
//    @Autowired
//    private HttpServletRequest request;

    @Override
    public AjaxResult dectEndDeviceNetWork(FacDeviceMetaSensorData facDeviceMetaSensorData) {
//        LocalDateTime now = LocalDateTime.now();
//        int n = Integer.valueOf(redisCache.getCacheObject(CacheConstants.SYS_CONFIG_KEY + "fac.net.time"));
//        LocalDateTime now_n = now.minusMinutes(n * 30);
//        request.setAttribute("params[beginAcquisitionTime]", now_n);
//        request.setAttribute("params[endAcquisitionTime]", now);

        List<FacDeviceMetaSensorData> facDeviceMetaSensorDataList = facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
        List<FacEndDevice> facEndDeviceList = facEndDeviceMapper.selectFacEndDeviceList(new FacEndDevice("1"));

//        System.out.println(request.getAttribute("params[beginAcquisitionTime]"));

        HashSet<String> connectDeviceId = new HashSet<>();
        HashSet<String> AllDeviceId = new HashSet<>();
        for (FacEndDevice facEndDevice : facEndDeviceList) {
            AllDeviceId.add(facEndDevice.getDeviceId());
            for (FacDeviceMetaSensorData facDeviceMetaSensorData1 : facDeviceMetaSensorDataList) {
                if (facEndDevice.getDeviceId().equals(facDeviceMetaSensorData1.getDeviceId())) {
                    connectDeviceId.add(facEndDevice.getDeviceId());
                }
            }
        }
        AllDeviceId.removeAll(connectDeviceId);
        return new AjaxResult(200, "断网的终端设备序号有：", AllDeviceId);
    }
}

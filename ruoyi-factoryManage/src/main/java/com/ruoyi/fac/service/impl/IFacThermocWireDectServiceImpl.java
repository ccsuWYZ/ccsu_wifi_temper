package com.ruoyi.fac.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.mapper.FacDeviceMetaSensorDataMapper;
import com.ruoyi.fac.service.IFacThermocWireDectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @date 2023-02-23 18:02:40
 * @description
 */
@Service
public class IFacThermocWireDectServiceImpl implements IFacThermocWireDectService {

    @Autowired
    private FacDeviceMetaSensorDataMapper facDeviceMetaSensorDataMapper;

    @Override
    public AjaxResult dectThermocWireDect(FacDeviceMetaSensorData facDeviceMetaSensorData) {
        HashSet<String> offWireThermocoupleId = new HashSet<>();
        List<FacDeviceMetaSensorData> facDeviceMetaSensorDataList = facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
        System.out.println(facDeviceMetaSensorDataList);
        for (FacDeviceMetaSensorData facDeviceMetaSensorData1 : facDeviceMetaSensorDataList) {
            if (("temper").equals(facDeviceMetaSensorData1.getType()) && ("1023").equals(facDeviceMetaSensorData1.getValue())) {
                offWireThermocoupleId.add(facDeviceMetaSensorData1.getDeviceId() + "," + facDeviceMetaSensorData1.getThermocoupleId());
            }
        }

        return new AjaxResult(200, "断线的热电偶序号有：", offWireThermocoupleId);
    }
}

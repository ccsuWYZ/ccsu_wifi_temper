package com.ruoyi.fac.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.service.IFacDeviceVoltageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *电压监测
 * @author lee
 * @date 2023-01-13 13:36:03
 * @description
 */
@RestController
@RequestMapping("/fac/endDeviceVol")
public class FacEndDeviceVolInfoController {
    @Autowired
    private IFacDeviceVoltageInfoService facDeviceVoltageInfoService;
    @PreAuthorize("@ss.hasPermi('fac:cellError:list')")
    @GetMapping("/list")
    public AjaxResult list(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return facDeviceVoltageInfoService.getDeviceVoltageInfo(facDeviceMetaSensorData);
    }
}

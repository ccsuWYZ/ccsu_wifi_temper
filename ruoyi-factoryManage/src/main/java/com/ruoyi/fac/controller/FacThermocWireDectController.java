package com.ruoyi.fac.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.service.IFacDeviceNetWorkDectService;
import com.ruoyi.fac.service.IFacThermocWireDectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断线检测
 * @author lee
 * @date 2023-02-23 18:28:39
 * @description
 */
@RestController
@RequestMapping("/fac/WireDect")
public class FacThermocWireDectController {
    @Autowired
    private IFacThermocWireDectService facThermocWireDectService;
    @GetMapping
    public AjaxResult getInfo(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return facThermocWireDectService.dectThermocWireDect(facDeviceMetaSensorData);
    }
}

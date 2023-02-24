package com.ruoyi.fac.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.service.IFacDeviceNetWorkDectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断网监测
 * @author lee
 * @date 2023-01-13 15:35:53
 * @description
 */
@RestController
@RequestMapping("/fac/NetWorkDect")
public class FacDeviceNetWorkDectController {
    @Autowired
    private IFacDeviceNetWorkDectService facDeviceNetWorkDectService;
    @GetMapping
    public AjaxResult getInfo(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return facDeviceNetWorkDectService.dectEndDeviceNetWork(facDeviceMetaSensorData);
    }
}

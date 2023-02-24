package com.ruoyi.fac.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.fac.service.IFacElectrolyticCellInfoService;

/**
 * 电解槽状态查询
 * 
 * @author ccsu
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/fac/cellError")
public class FacElectrolyticCellInfoController extends BaseController
{
    @Autowired
    private IFacElectrolyticCellInfoService facElectrolyticCellInfoService;

    /**
     * 查询电解槽信息列表
     */
    @PreAuthorize("@ss.hasPermi('fac:cellError:list')")
    @GetMapping("/list")
    public AjaxResult list(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return facElectrolyticCellInfoService.getElectrolyticCellInfo(facDeviceMetaSensorData);
    }

}

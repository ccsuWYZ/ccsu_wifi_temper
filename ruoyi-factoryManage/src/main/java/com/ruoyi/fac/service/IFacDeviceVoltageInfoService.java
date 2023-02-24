package com.ruoyi.fac.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @date 2023-01-13 11:41:15
 * @description
 */
public interface IFacDeviceVoltageInfoService {
    public AjaxResult getDeviceVoltageInfo(FacDeviceMetaSensorData facDeviceMetaSensorData);
}

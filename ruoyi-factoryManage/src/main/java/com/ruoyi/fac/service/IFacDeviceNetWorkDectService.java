package com.ruoyi.fac.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @date 2023-01-13 14:12:00
 * @description
 */
public interface IFacDeviceNetWorkDectService {
    public AjaxResult dectEndDeviceNetWork(FacDeviceMetaSensorData facDeviceMetaSensorData);
}

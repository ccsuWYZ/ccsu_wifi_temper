package com.ruoyi.fac.service.impl;

import com.ruoyi.fac.mapper.FacDeviceMetaSensorDataMapper;
import com.ruoyi.fac.service.IFacHistoryDataRemoveService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @date 2023-02-23 20:53:28
 * @description
 */
@Service
public class IFacHistoryDataRemoveServiceImpl implements IFacHistoryDataRemoveService {
    @Autowired
    private FacDeviceMetaSensorDataMapper facDeviceMetaSensorDataMapper;

    @Override
    public void backUpData(Integer days) {
     facDeviceMetaSensorDataMapper.backUpSensorData(days);
    }

    @Override
    public void removeData(Integer days) {
        facDeviceMetaSensorDataMapper.deleteHistorySensorData(days);
    }
}

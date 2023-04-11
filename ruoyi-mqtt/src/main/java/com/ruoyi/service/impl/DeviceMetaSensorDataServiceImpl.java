package com.ruoyi.service.impl;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.fac.domain.*;
import com.ruoyi.fac.mapper.FacDeviceMetaSensorDataMapper;
import com.ruoyi.fac.mapper.FacDeviceMetaTemperMapper;
import com.ruoyi.service.DeviceMetaSensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @date 2022-11-14 20:00:59
 * @description
 */
@Service
//    @Resource
public class DeviceMetaSensorDataServiceImpl implements DeviceMetaSensorDataService {

    @Autowired
    private FacDeviceMetaSensorDataMapper facDeviceMetaSensorDataMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public void insertDeviceMetaTemper(Map<String, Object> mqttMessage) {

        Long factory_id;
        String factory_name;

        Long workshop_id;
        String workshop_name;

        Long ele_cell_id;
        String ele_cell_name;

        String device_id = String.valueOf(mqttMessage.get("device_id"));
        String device_name;

        String thermocouple_id;
        String thermocouple_name;
        String thermocouple_location;

        String Temp;
        //1.根据device_id 找电解槽id,设备名称,热电偶id，热电偶名称，热电偶位置(四个)

        FacEndDevice facEndDevice = redisCache.getCacheObject(CacheConstants.DEVICE_INFO_KEY + device_id);

        //该终端下的四个热电偶信息
        List<FacThermocouple> facThermocoupleList = redisCache.getCacheList(CacheConstants.THERMOCOUPLE_INFO_KEY + device_id);

        ele_cell_id = Long.valueOf(Math.toIntExact(facEndDevice.getElectrolyticellId()));//该终端所属的电解槽id

        device_name = facEndDevice.getDeviceName();

        //2.根据电解槽id获取到电解槽的名称，车间的id
        FacElectrolyticCell facElectrolyticCell = redisCache.getCacheObject(CacheConstants.ELECELL_INFO_KEY + ele_cell_id);
        ele_cell_name = facElectrolyticCell.getElectrolyticcellName();
        workshop_id = Long.valueOf(Math.toIntExact(facElectrolyticCell.getWorkshopId()));

        //根据车间的id找到工厂的id，车间的名称
        FacWorkshop facWorkshop = redisCache.getCacheObject(CacheConstants.WORKSHOP_INFO_KEY + workshop_id);
        factory_id = Long.valueOf(Math.toIntExact(facWorkshop.getFactoryId()));
        workshop_name = facWorkshop.getWorkshopName();

        //根据工厂的id找到 工厂的名称
        FacInfo facInfo = redisCache.getCacheObject(CacheConstants.FAC_INFO_KEY + factory_id);
        factory_name = facInfo.getFactoryName();

        //得到电压
        String voltage = String.valueOf(mqttMessage.get("voltage"));

        for (int i = 0; i < facThermocoupleList.size(); i++) {
            thermocouple_id = facThermocoupleList.get(i).getThermocoupleId();
            Temp = String.valueOf(mqttMessage.get(thermocouple_id));
            if (Temp == null) {
                continue;
            }

            thermocouple_location = facThermocoupleList.get(i).getThermocoupleLocation();

            thermocouple_name = facThermocoupleList.get(i).getThermocoupleName();

            FacDeviceMetaSensorData temperData = new FacDeviceMetaSensorData(Temp, "temper", thermocouple_id, thermocouple_name, thermocouple_location, device_id, device_name, ele_cell_id, ele_cell_name, workshop_id, workshop_name, factory_id, factory_name);


            facDeviceMetaSensorDataMapper.insertFacDeviceMetaSensorData(temperData);

        }
        FacDeviceMetaSensorData voltageData = new FacDeviceMetaSensorData(voltage, "voltage", device_id, device_name, ele_cell_id, ele_cell_name, workshop_id, workshop_name, factory_id, factory_name);
        facDeviceMetaSensorDataMapper.insertFacDeviceMetaSensorData(voltageData);

    }
}

package com.ruoyi.fac.mapper;

import java.util.List;
import com.ruoyi.fac.domain.FacEndDevice;
import com.ruoyi.fac.domain.FacThermocouple;

/**
 * 设备管理Mapper接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface FacEndDeviceMapper 
{
    /**
     * 查询设备管理
     * 
     * @param deviceId 设备管理主键
     * @return 设备管理
     */
    public FacEndDevice selectFacEndDeviceByDeviceId(String deviceId);

    /**
     * 查询设备管理列表
     * 
     * @param facEndDevice 设备管理
     * @return 设备管理集合
     */
    public List<FacEndDevice> selectFacEndDeviceList(FacEndDevice facEndDevice);

    /**
     * 新增设备管理
     * 
     * @param facEndDevice 设备管理
     * @return 结果
     */
    public int insertFacEndDevice(FacEndDevice facEndDevice);

    /**
     * 修改设备管理
     * 
     * @param facEndDevice 设备管理
     * @return 结果
     */
    public int updateFacEndDevice(FacEndDevice facEndDevice);

    /**
     * 删除设备管理
     * 
     * @param deviceId 设备管理主键
     * @return 结果
     */
    public int deleteFacEndDeviceByDeviceId(String deviceId);

    /**
     * 批量删除设备管理
     * 
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacEndDeviceByDeviceIds(String[] deviceIds);

    /**
     * 批量删除热电偶
     * 
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacThermocoupleByEndDeviceIds(String[] deviceIds);
    
    /**
     * 批量新增热电偶
     * 
     * @param facThermocoupleList 热电偶列表
     * @return 结果
     */
    public int batchFacThermocouple(List<FacThermocouple> facThermocoupleList);
    

    /**
     * 通过设备管理主键删除热电偶信息
     * 
     * @param deviceId 设备管理ID
     * @return 结果
     */
    public int deleteFacThermocoupleByEndDeviceId(String deviceId);
}

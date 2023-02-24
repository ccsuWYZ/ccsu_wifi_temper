package com.ruoyi.fac.service;

import java.util.List;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;

/**
 * 传感器数据Service接口
 * 
 * @author ccsu
 * @date 2023-01-13
 */
public interface IFacDeviceMetaSensorDataService 
{
    /**
     * 查询传感器数据
     * 
     * @param sensorDataId 传感器数据主键
     * @return 传感器数据
     */
    public FacDeviceMetaSensorData selectFacDeviceMetaSensorDataBySensorDataId(Integer sensorDataId);

    /**
     * 查询传感器数据列表
     * 
     * @param facDeviceMetaSensorData 传感器数据
     * @return 传感器数据集合
     */
    public List<FacDeviceMetaSensorData> selectFacDeviceMetaSensorDataList(FacDeviceMetaSensorData facDeviceMetaSensorData);

    /**
     * 新增传感器数据
     * 
     * @param facDeviceMetaSensorData 传感器数据
     * @return 结果
     */
    public int insertFacDeviceMetaSensorData(FacDeviceMetaSensorData facDeviceMetaSensorData);

    /**
     * 修改传感器数据
     * 
     * @param facDeviceMetaSensorData 传感器数据
     * @return 结果
     */
    public int updateFacDeviceMetaSensorData(FacDeviceMetaSensorData facDeviceMetaSensorData);

    /**
     * 批量删除传感器数据
     * 
     * @param sensorDataIds 需要删除的传感器数据主键集合
     * @return 结果
     */
    public int deleteFacDeviceMetaSensorDataBySensorDataIds(Integer[] sensorDataIds);

    /**
     * 删除传感器数据信息
     * 
     * @param sensorDataId 传感器数据主键
     * @return 结果
     */
    public int deleteFacDeviceMetaSensorDataBySensorDataId(Integer sensorDataId);
}

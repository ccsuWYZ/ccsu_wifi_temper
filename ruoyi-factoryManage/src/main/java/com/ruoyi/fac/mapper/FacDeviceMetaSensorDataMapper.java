package com.ruoyi.fac.mapper;

import java.util.List;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;

/**
 * 传感器数据Mapper接口
 * 
 * @author ccsu
 * @date 2023-01-13
 */
public interface FacDeviceMetaSensorDataMapper 
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
    public List<FacDeviceMetaSensorData> selectFacDeviceMetaSensorDataList_history(FacDeviceMetaSensorData facDeviceMetaSensorData);

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
     * 删除传感器数据
     * 
     * @param sensorDataId 传感器数据主键
     * @return 结果
     */
    public int deleteFacDeviceMetaSensorDataBySensorDataId(Integer sensorDataId);

    /**
     * 批量删除传感器数据
     * 
     * @param sensorDataIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacDeviceMetaSensorDataBySensorDataIds(Integer[] sensorDataIds);

    /**
     * 批量备份传感器数据
     */
    public int  backUpSensorData(Integer days);

   /**
    * 批量删除传感器数据
    */
    public int deleteHistorySensorData(Integer days);
}

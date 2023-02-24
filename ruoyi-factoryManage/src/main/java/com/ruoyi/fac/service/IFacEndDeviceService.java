package com.ruoyi.fac.service;

import java.util.List;
import com.ruoyi.fac.domain.FacEndDevice;

/**
 * 设备管理Service接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface IFacEndDeviceService 
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
     * 批量删除设备管理
     * 
     * @param deviceIds 需要删除的设备管理主键集合
     * @return 结果
     */
    public int deleteFacEndDeviceByDeviceIds(String[] deviceIds);

    /**
     * 删除设备管理信息
     * 
     * @param deviceId 设备管理主键
     * @return 结果
     */
    public int deleteFacEndDeviceByDeviceId(String deviceId);


    /**
     * 加载参数缓存数据
     */
    public void loadingConfigCache();

    /**
     * 清空参数缓存数据
     */
    public void clearConfigCache();

    /**
     * 重置参数缓存数据
     */
    public void resetConfigCache();


}

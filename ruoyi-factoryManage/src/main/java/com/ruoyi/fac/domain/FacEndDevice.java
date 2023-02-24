package com.ruoyi.fac.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 设备管理对象 fac_end_device
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
public class FacEndDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备所在电解槽的位置 */
    @Excel(name = "设备所在电解槽的位置")
    private String location;

    /** 设备所属的电解槽的编号 */
    @Excel(name = "设备所属的电解槽的编号")
    private Long electrolyticellId;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String deviceStatus;

    private List<FacThermocouple> facThermocoupleList;

    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setElectrolyticellId(Long electrolyticellId) 
    {
        this.electrolyticellId = electrolyticellId;
    }

    public Long getElectrolyticellId() 
    {
        return electrolyticellId;
    }
    public void setDeviceStatus(String deviceStatus) 
    {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceStatus() 
    {
        return deviceStatus;
    }

    public List<FacThermocouple> getFacThermocoupleList() {
        return facThermocoupleList;
    }

    public void setFacThermocoupleList(List<FacThermocouple> facThermocoupleList) {
        this.facThermocoupleList = facThermocoupleList;
    }

    public FacEndDevice() {
    }

    public FacEndDevice(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("location", getLocation())
            .append("electrolyticellId", getElectrolyticellId())
            .append("deviceStatus", getDeviceStatus())
            .toString();
    }
}

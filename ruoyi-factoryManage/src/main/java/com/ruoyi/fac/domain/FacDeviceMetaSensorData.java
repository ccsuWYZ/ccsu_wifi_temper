package com.ruoyi.fac.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 传感器数据对象 fac_device_meta_sensor_data
 * 
 * @author ccsu
 * @date 2023-01-13
 */
public class FacDeviceMetaSensorData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 传感器数据编号 */
    private Integer sensorDataId;

    /** 数值 */
    @Excel(name = "数值")
    private String value;

    /** 数据类型 */
    @Excel(name = "数据类型")
    private String type;

    /** 采集的时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "采集的时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date acquisitionTime;

    /** 所属热电偶的编号 */
    @Excel(name = "所属热电偶的编号")
    private String thermocoupleId;

    /** 所属热电偶的名称 */
    @Excel(name = "所属热电偶的名称")
    private String thermocoupleName;

    /** 所属热电偶的位置 */
    @Excel(name = "所属热电偶的位置")
    private String thermocoupleLocation;

    /** 终端设备的编号 */
    @Excel(name = "终端设备的编号")
    private String deviceId;

    /** 终端设备的名称 */
    @Excel(name = "终端设备的名称")
    private String deviceName;

    /** 所属电解槽的编号 */
    @Excel(name = "所属电解槽的编号")
    private Long electrolyticCellId;

    /** 所属电解槽的名称 */
    @Excel(name = "所属电解槽的名称")
    private String electrolyticCellName;

    /** 所属车间的编号 */
    @Excel(name = "所属车间的编号")
    private Long workshopId;

    /** 所属车间的名称 */
    @Excel(name = "所属车间的名称")
    private String workshopName;

    /** 所属工厂的编号 */
    @Excel(name = "所属工厂的编号")
    private Long factoryId;

    /** 所属工厂的名称 */
    @Excel(name = "所属工厂的名称")
    private String factoryName;

    public void setSensorDataId(Integer sensorDataId) 
    {
        this.sensorDataId = sensorDataId;
    }

    public Integer getSensorDataId() 
    {
        return sensorDataId;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setAcquisitionTime(Date acquisitionTime) 
    {
        this.acquisitionTime = acquisitionTime;
    }

    public Date getAcquisitionTime() 
    {
        return acquisitionTime;
    }
    public void setThermocoupleId(String thermocoupleId) 
    {
        this.thermocoupleId = thermocoupleId;
    }

    public String getThermocoupleId() 
    {
        return thermocoupleId;
    }
    public void setThermocoupleName(String thermocoupleName) 
    {
        this.thermocoupleName = thermocoupleName;
    }

    public String getThermocoupleName() 
    {
        return thermocoupleName;
    }
    public void setThermocoupleLocation(String thermocoupleLocation) 
    {
        this.thermocoupleLocation = thermocoupleLocation;
    }

    public String getThermocoupleLocation() 
    {
        return thermocoupleLocation;
    }
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
    public void setElectrolyticCellId(Long electrolyticCellId) 
    {
        this.electrolyticCellId = electrolyticCellId;
    }

    public Long getElectrolyticCellId() 
    {
        return electrolyticCellId;
    }
    public void setElectrolyticCellName(String electrolyticCellName) 
    {
        this.electrolyticCellName = electrolyticCellName;
    }

    public String getElectrolyticCellName() 
    {
        return electrolyticCellName;
    }
    public void setWorkshopId(Long workshopId) 
    {
        this.workshopId = workshopId;
    }

    public Long getWorkshopId() 
    {
        return workshopId;
    }
    public void setWorkshopName(String workshopName) 
    {
        this.workshopName = workshopName;
    }

    public String getWorkshopName() 
    {
        return workshopName;
    }
    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
    }
    public void setFactoryName(String factoryName) 
    {
        this.factoryName = factoryName;
    }

    public String getFactoryName() 
    {
        return factoryName;
    }

    public FacDeviceMetaSensorData() {
    }

    public FacDeviceMetaSensorData(String value, String type, String thermocoupleId, String thermocoupleName, String thermocoupleLocation, String deviceId, String deviceName, Long electrolyticCellId, String electrolyticCellName, Long workshopId, String workshopName, Long factoryId, String factoryName) {
        this.value = value;
        this.type = type;
        this.thermocoupleId = thermocoupleId;
        this.thermocoupleName = thermocoupleName;
        this.thermocoupleLocation = thermocoupleLocation;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.electrolyticCellId = electrolyticCellId;
        this.electrolyticCellName = electrolyticCellName;
        this.workshopId = workshopId;
        this.workshopName = workshopName;
        this.factoryId = factoryId;
        this.factoryName = factoryName;
    }

    public FacDeviceMetaSensorData(String value, String type ,String deviceId, String deviceName, Long electrolyticCellId, String electrolyticCellName, Long workshopId, String workshopName, Long factoryId, String factoryName) {
        this.value = value;
        this.type = type;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.electrolyticCellId = electrolyticCellId;
        this.electrolyticCellName = electrolyticCellName;
        this.workshopId = workshopId;
        this.workshopName = workshopName;
        this.factoryId = factoryId;
        this.factoryName = factoryName;
    }

    public FacDeviceMetaSensorData(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sensorDataId", getSensorDataId())
            .append("value", getValue())
            .append("type", getType())
            .append("acquisitionTime", getAcquisitionTime())
            .append("thermocoupleId", getThermocoupleId())
            .append("thermocoupleName", getThermocoupleName())
            .append("thermocoupleLocation", getThermocoupleLocation())
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("electrolyticCellId", getElectrolyticCellId())
            .append("electrolyticCellName", getElectrolyticCellName())
            .append("workshopId", getWorkshopId())
            .append("workshopName", getWorkshopName())
            .append("factoryId", getFactoryId())
            .append("factoryName", getFactoryName())
            .toString();
    }
}

package com.ruoyi.fac.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 温度管理对象 fac_device_meta_temper
 *
 * @author ccsu
 * @date 2022-11-23
 */
public class FacDeviceMetaTemper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long temperId;

    /** 温度值 */
    @Excel(name = "温度值")
    private Integer temp;

    /** 采集的时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "采集的时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date acquisitionTime;

    /** 终端设备的编号 */
    @Excel(name = "终端设备的编号")
    private String deviceId;

    /** 终端设备的名称 */
    @Excel(name = "终端设备的名称")
    private String deviceName;

    /** 热电偶的编号 */
    @Excel(name = "热电偶的编号")
    private String thermocoupleId;

    /** 热电偶的名称 */
    @Excel(name = "热电偶的名称")
    private String thermocoupleName;

    /** 热点偶的位置 */
    @Excel(name = "热点偶的位置")
    private String thermocoupleLocation;

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

    public void setTemperId(Long temperId)
    {
        this.temperId = temperId;
    }

    public Long getTemperId()
    {
        return temperId;
    }
    public void setTemp(Integer temp)
    {
        this.temp = temp;
    }

    public Integer getTemp()
    {
        return temp;
    }
    public void setAcquisitionTime(Date acquisitionTime)
    {
        this.acquisitionTime = acquisitionTime;
    }

    public Date getAcquisitionTime()
    {
        return acquisitionTime;
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

    public FacDeviceMetaTemper( Integer temp, String deviceId, String deviceName, String thermocoupleId, String thermocoupleName, String thermocoupleLocation, Long electrolyticCellId, String electrolyticCellName, Long workshopId, String workshopName, Long factoryId, String factoryName) {
//        this.temperId = temperId;
        this.temp = temp;
//        this.acquisitionTime = acquisitionTime;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.thermocoupleId = thermocoupleId;
        this.thermocoupleName = thermocoupleName;
        this.thermocoupleLocation = thermocoupleLocation;
        this.electrolyticCellId = electrolyticCellId;
        this.electrolyticCellName = electrolyticCellName;
        this.workshopId = workshopId;
        this.workshopName = workshopName;
        this.factoryId = factoryId;
        this.factoryName = factoryName;
    }

    public FacDeviceMetaTemper() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("temperId", getTemperId())
                .append("temp", getTemp())
                .append("acquisitionTime", getAcquisitionTime())
                .append("deviceId", getDeviceId())
                .append("deviceName", getDeviceName())
                .append("thermocoupleId", getThermocoupleId())
                .append("thermocoupleName", getThermocoupleName())
                .append("thermocoupleLocation", getThermocoupleLocation())
                .append("electrolyticCellId", getElectrolyticCellId())
                .append("electrolyticCellName", getElectrolyticCellName())
                .append("workshopId", getWorkshopId())
                .append("workshopName", getWorkshopName())
                .append("factoryId", getFactoryId())
                .append("factoryName", getFactoryName())
                .toString();
    }
}

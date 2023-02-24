package com.ruoyi.fac.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 热电偶对象 fac_thermocouple
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
public class FacThermocouple extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 热点偶编号 */
    private String thermocoupleId;

    /** 热点偶名称 */
    @Excel(name = "热点偶名称")
    private String thermocoupleName;

    /** 热点偶所在的位置 */
    @Excel(name = "热点偶所在的位置")
    private String thermocoupleLocation;

    /** 所属的终端名称 */
    @Excel(name = "所属的终端名称")
    private String endDeviceId;

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
    public void setEndDeviceId(String endDeviceId) 
    {
        this.endDeviceId = endDeviceId;
    }

    public String getEndDeviceId() 
    {
        return endDeviceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("thermocoupleId", getThermocoupleId())
            .append("thermocoupleName", getThermocoupleName())
            .append("thermocoupleLocation", getThermocoupleLocation())
            .append("endDeviceId", getEndDeviceId())
            .toString();
    }
}

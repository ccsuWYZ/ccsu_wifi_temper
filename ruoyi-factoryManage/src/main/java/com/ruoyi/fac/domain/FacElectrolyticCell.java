package com.ruoyi.fac.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电解槽管理对象 fac_electrolytic_cell
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
public class FacElectrolyticCell extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 电解槽编号 */
    private Long electrolyticcellId;

    /** 电解槽名称 */
    @Excel(name = "电解槽名称")
    private String electrolyticcellName;

    /** 电解槽的位置 */
    @Excel(name = "电解槽的位置")
    private String electrolyticcellLocation;

    /** 车间编号，外键 */
    @Excel(name = "车间编号，外键")
    private Long workshopId;

    /** 设备管理信息 */
    private List<FacEndDevice> facEndDeviceList;

    public void setElectrolyticcellId(Long electrolyticcellId) 
    {
        this.electrolyticcellId = electrolyticcellId;
    }

    public Long getElectrolyticcellId() 
    {
        return electrolyticcellId;
    }
    public void setElectrolyticcellName(String electrolyticcellName) 
    {
        this.electrolyticcellName = electrolyticcellName;
    }

    public String getElectrolyticcellName() 
    {
        return electrolyticcellName;
    }
    public void setElectrolyticcellLocation(String electrolyticcellLocation) 
    {
        this.electrolyticcellLocation = electrolyticcellLocation;
    }

    public String getElectrolyticcellLocation() 
    {
        return electrolyticcellLocation;
    }
    public void setWorkshopId(Long workshopId) 
    {
        this.workshopId = workshopId;
    }

    public Long getWorkshopId() 
    {
        return workshopId;
    }

    public List<FacEndDevice> getFacEndDeviceList()
    {
        return facEndDeviceList;
    }

    public void setFacEndDeviceList(List<FacEndDevice> facEndDeviceList)
    {
        this.facEndDeviceList = facEndDeviceList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("electrolyticcellId", getElectrolyticcellId())
            .append("electrolyticcellName", getElectrolyticcellName())
            .append("electrolyticcellLocation", getElectrolyticcellLocation())
            .append("workshopId", getWorkshopId())
            .append("facEndDeviceList", getFacEndDeviceList())
            .toString();
    }
}

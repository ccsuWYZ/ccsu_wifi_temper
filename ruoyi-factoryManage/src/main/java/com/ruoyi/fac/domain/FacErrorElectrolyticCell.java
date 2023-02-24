package com.ruoyi.fac.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电解槽故障对象 fac_error_electrolytic_cell
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public class FacErrorElectrolyticCell extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 故障发生的时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "故障发生的时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date happenTime;

    /** 所属电解槽的编号 */
    private Long electrolyticCellId;

    /** 所属电解槽的名称 */
    @Excel(name = "所属电解槽的名称")
    private String electrolyticCellName;

    /** 故障电解槽的位置 */
    @Excel(name = "故障电解槽的位置")
    private String electrolyticCellLocation;

    /** 所属车间的编号 */
    private Long workshopId;

    /** 所属车间的名称 */
    @Excel(name = "所属车间的名称")
    private String workshopName;

    /** 所属工厂的编号 */
    private Long factoryId;

    /** 所属工厂的名称 */
    @Excel(name = "所属工厂的名称")
    private String factoryName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHappenTime(Date happenTime) 
    {
        this.happenTime = happenTime;
    }

    public Date getHappenTime() 
    {
        return happenTime;
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
    public void setElectrolyticCellLocation(String electrolyticCellLocation) 
    {
        this.electrolyticCellLocation = electrolyticCellLocation;
    }

    public String getElectrolyticCellLocation() 
    {
        return electrolyticCellLocation;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("happenTime", getHappenTime())
            .append("electrolyticCellId", getElectrolyticCellId())
            .append("electrolyticCellName", getElectrolyticCellName())
            .append("electrolyticCellLocation", getElectrolyticCellLocation())
            .append("workshopId", getWorkshopId())
            .append("workshopName", getWorkshopName())
            .append("factoryId", getFactoryId())
            .append("factoryName", getFactoryName())
            .toString();
    }
}

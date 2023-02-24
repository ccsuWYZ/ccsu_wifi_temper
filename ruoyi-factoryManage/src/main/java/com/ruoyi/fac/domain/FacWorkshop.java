package com.ruoyi.fac.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 生产车间对象 fac_workshop
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public class FacWorkshop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车间编号，自增 */
    private Long workshopId;

    /** 车间名称 */
    @Excel(name = "车间名称")
    private String workshopName;

    /** 车间位置 */
    @Excel(name = "车间位置")
    private String workshopLocation;

    /** 所属工厂的编号 */
    @Excel(name = "所属工厂的编号")
    private Long factoryId;

    private List<FacElectrolyticCell> facElectrolyticCellList;

    public List<FacElectrolyticCell> getFacElectrolyticCellList() {
        return facElectrolyticCellList;
    }

    public void setFacElectrolyticCellList(List<FacElectrolyticCell> facElectrolyticCellList) {
        this.facElectrolyticCellList = facElectrolyticCellList;
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
    public void setWorkshopLocation(String workshopLocation) 
    {
        this.workshopLocation = workshopLocation;
    }

    public String getWorkshopLocation() 
    {
        return workshopLocation;
    }
    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workshopId", getWorkshopId())
            .append("workshopName", getWorkshopName())
            .append("workshopLocation", getWorkshopLocation())
            .append("factoryId", getFactoryId())
            .toString();
    }
}

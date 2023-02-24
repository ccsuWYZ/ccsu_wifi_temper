package com.ruoyi.fac.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工厂管理对象 fac_info
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public class FacInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工厂编号 */
    private Long factoryId;

    /** 工厂名称 */
    @Excel(name = "工厂名称")
    private String factoryName;

    /** 工厂地址 */
    @Excel(name = "工厂地址")
    private String factoryLocation;

    /** 生产车间信息 */
    private List<FacWorkshop> facWorkshopList;

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
    public void setFactoryLocation(String factoryLocation) 
    {
        this.factoryLocation = factoryLocation;
    }

    public String getFactoryLocation() 
    {
        return factoryLocation;
    }

    public List<FacWorkshop> getFacWorkshopList()
    {
        return facWorkshopList;
    }

    public void setFacWorkshopList(List<FacWorkshop> facWorkshopList)
    {
        this.facWorkshopList = facWorkshopList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("factoryId", getFactoryId())
            .append("factoryName", getFactoryName())
            .append("factoryLocation", getFactoryLocation())
            .append("facWorkshopList", getFacWorkshopList())
            .toString();
    }
}

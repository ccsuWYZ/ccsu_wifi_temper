//package com.ruoyi.domain;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.ruoyi.common.annotation.Excel;
//import com.ruoyi.common.core.domain.BaseEntity;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.apache.commons.lang3.builder.ToStringStyle;
//
//import java.util.Date;
//
///**
// * 温度采集对象 fac_device_meta_temper
// *
// * @author ccsu
// * @date 2022-11-14
// */
//public class FacDeviceMetaTemper extends BaseEntity
//{
//    private static final long serialVersionUID = 1L;
//
//    /** 编号 */
//    private Long temperId;
//
//    /** 温度值1 */
//    @Excel(name = "温度值1")
//    private Long temp1;
//
//    /** 温度值2 */
//    @Excel(name = "温度值2")
//    private Long temp2;
//
//    /** 温度值3 */
//    @Excel(name = "温度值3")
//    private Long temp3;
//
//    /** 温度值4 */
//    @Excel(name = "温度值4")
//    private Long temp4;
//
//    /** 采集的时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "采集的时间", width = 30, dateFormat = "yyyy-MM-dd")
//    private Date acquisitionTime;
//
//    /** 采集设备的编号 */
//    private Long deviceId;
//
//    /** 所属电解槽的编号 */
//    private Long electrolyticCellId;
//
//    /** 所属车间的编号 */
//    private Long workshopId;
//
//    /** 所属车间的名称 */
//    @Excel(name = "所属车间的名称")
//    private String workshopName;
//
//    /** 所属电解槽的名称 */
//    @Excel(name = "所属电解槽的名称")
//    private String electrolyticCellName;
//
//    /** 采集设备的名称 */
//    @Excel(name = "采集设备的名称")
//    private String deviceName;
//
//    /** 所属工厂的编号 */
//    private Long factoryId;
//
//    /** 所属工厂的名称 */
//    @Excel(name = "所属工厂的名称")
//    private String factoryName;
//
//    public void setTemperId(Long temperId)
//    {
//        this.temperId = temperId;
//    }
//
//    public Long getTemperId()
//    {
//        return temperId;
//    }
//    public void setTemp1(Long temp1)
//    {
//        this.temp1 = temp1;
//    }
//
//    public Long getTemp1()
//    {
//        return temp1;
//    }
//    public void setTemp2(Long temp2)
//    {
//        this.temp2 = temp2;
//    }
//
//    public Long getTemp2()
//    {
//        return temp2;
//    }
//    public void setTemp3(Long temp3)
//    {
//        this.temp3 = temp3;
//    }
//
//    public Long getTemp3()
//    {
//        return temp3;
//    }
//    public void setTemp4(Long temp4)
//    {
//        this.temp4 = temp4;
//    }
//
//    public Long getTemp4()
//    {
//        return temp4;
//    }
//    public void setAcquisitionTime(Date acquisitionTime)
//    {
//        this.acquisitionTime = acquisitionTime;
//    }
//
//    public Date getAcquisitionTime()
//    {
//        return acquisitionTime;
//    }
//    public void setDeviceId(Long deviceId)
//    {
//        this.deviceId = deviceId;
//    }
//
//    public Long getDeviceId()
//    {
//        return deviceId;
//    }
//    public void setElectrolyticCellId(Long electrolyticCellId)
//    {
//        this.electrolyticCellId = electrolyticCellId;
//    }
//
//    public Long getElectrolyticCellId()
//    {
//        return electrolyticCellId;
//    }
//    public void setWorkshopId(Long workshopId)
//    {
//        this.workshopId = workshopId;
//    }
//
//    public Long getWorkshopId()
//    {
//        return workshopId;
//    }
//    public void setWorkshopName(String workshopName)
//    {
//        this.workshopName = workshopName;
//    }
//
//    public String getWorkshopName()
//    {
//        return workshopName;
//    }
//    public void setElectrolyticCellName(String electrolyticCellName)
//    {
//        this.electrolyticCellName = electrolyticCellName;
//    }
//
//    public String getElectrolyticCellName()
//    {
//        return electrolyticCellName;
//    }
//    public void setDeviceName(String deviceName)
//    {
//        this.deviceName = deviceName;
//    }
//
//    public String getDeviceName()
//    {
//        return deviceName;
//    }
//    public void setFactoryId(Long factoryId)
//    {
//        this.factoryId = factoryId;
//    }
//
//    public Long getFactoryId()
//    {
//        return factoryId;
//    }
//    public void setFactoryName(String factoryName)
//    {
//        this.factoryName = factoryName;
//    }
//
//    public String getFactoryName()
//    {
//        return factoryName;
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
//            .append("temperId", getTemperId())
//            .append("temp1", getTemp1())
//            .append("temp2", getTemp2())
//            .append("temp3", getTemp3())
//            .append("temp4", getTemp4())
//            .append("acquisitionTime", getAcquisitionTime())
//            .append("deviceId", getDeviceId())
//            .append("electrolyticCellId", getElectrolyticCellId())
//            .append("workshopId", getWorkshopId())
//            .append("workshopName", getWorkshopName())
//            .append("electrolyticCellName", getElectrolyticCellName())
//            .append("deviceName", getDeviceName())
//            .append("factoryId", getFactoryId())
//            .append("factoryName", getFactoryName())
//            .toString();
//    }
//}

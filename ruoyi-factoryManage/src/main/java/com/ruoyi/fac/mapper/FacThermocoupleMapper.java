package com.ruoyi.fac.mapper;

import java.util.List;
import com.ruoyi.fac.domain.FacThermocouple;

/**
 * 热电偶Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
public interface FacThermocoupleMapper 
{
    /**
     * 查询热电偶
     * 
     * @param thermocoupleId 热电偶主键
     * @return 热电偶
     */
    public FacThermocouple selectFacThermocoupleByThermocoupleId(String thermocoupleId);


     public List<FacThermocouple>   selectFacThermocoupleByEndDeviceId(String endDeviceId);


    /**
     * 查询热电偶列表
     * 
     * @param facThermocouple 热电偶
     * @return 热电偶集合
     */
    public List<FacThermocouple> selectFacThermocoupleList(FacThermocouple facThermocouple);

    /**
     * 新增热电偶
     * 
     * @param facThermocouple 热电偶
     * @return 结果
     */
    public int insertFacThermocouple(FacThermocouple facThermocouple);

    /**
     * 修改热电偶
     * 
     * @param facThermocouple 热电偶
     * @return 结果
     */
    public int updateFacThermocouple(FacThermocouple facThermocouple);

    /**
     * 删除热电偶
     * 
     * @param thermocoupleId 热电偶主键
     * @return 结果
     */
    public int deleteFacThermocoupleByThermocoupleId(String thermocoupleId);

    /**
     * 批量删除热电偶
     * 
     * @param thermocoupleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacThermocoupleByThermocoupleIds(String[] thermocoupleIds);
}

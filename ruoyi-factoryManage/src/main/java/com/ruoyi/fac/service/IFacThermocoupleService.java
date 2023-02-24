package com.ruoyi.fac.service;

import java.util.List;
import com.ruoyi.fac.domain.FacThermocouple;

/**
 * 热电偶Service接口
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
public interface IFacThermocoupleService 
{
    /**
     * 查询热电偶
     * 
     * @param thermocoupleId 热电偶主键
     * @return 热电偶
     */
    public FacThermocouple selectFacThermocoupleByThermocoupleId(String thermocoupleId);

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
     * 批量删除热电偶
     * 
     * @param thermocoupleIds 需要删除的热电偶主键集合
     * @return 结果
     */
    public int deleteFacThermocoupleByThermocoupleIds(String[] thermocoupleIds);

    /**
     * 删除热电偶信息
     * 
     * @param thermocoupleId 热电偶主键
     * @return 结果
     */
    public int deleteFacThermocoupleByThermocoupleId(String thermocoupleId);

    /**
     * 加载参数缓存数据
     */
    public void loadingConfigCache();

    /**
     * 清空参数缓存数据
     */
    public void clearConfigCache();

    /**
     * 重置参数缓存数据
     */
    public void resetConfigCache();
}

package com.ruoyi.fac.service;

import java.util.List;
import com.ruoyi.fac.domain.FacDeviceMetaTemper;

/**
 * 温度管理Service接口
 *
 * @author ccsu
 * @date 2022-12-27
 */
public interface IFacDeviceMetaTemperService
{
    /**
     * 查询温度管理
     *
     * @param temperId 温度管理主键
     * @return 温度管理
     */
    public FacDeviceMetaTemper selectFacDeviceMetaTemperByTemperId(Long temperId);

    /**
     * 查询温度管理列表
     *
     * @param facDeviceMetaTemper 温度管理
     * @return 温度管理集合
     */
    public List<FacDeviceMetaTemper> selectFacDeviceMetaTemperList(FacDeviceMetaTemper facDeviceMetaTemper);

    /**
     * 新增温度管理
     *
     * @param facDeviceMetaTemper 温度管理
     * @return 结果
     */
    public int insertFacDeviceMetaTemper(FacDeviceMetaTemper facDeviceMetaTemper);

    /**
     * 修改温度管理
     *
     * @param facDeviceMetaTemper 温度管理
     * @return 结果
     */
    public int updateFacDeviceMetaTemper(FacDeviceMetaTemper facDeviceMetaTemper);

    /**
     * 批量删除温度管理
     *
     * @param temperIds 需要删除的温度管理主键集合
     * @return 结果
     */
    public int deleteFacDeviceMetaTemperByTemperIds(Long[] temperIds);

    /**
     * 删除温度管理信息
     *
     * @param temperId 温度管理主键
     * @return 结果
     */
    public int deleteFacDeviceMetaTemperByTemperId(Long temperId);
}

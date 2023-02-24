package com.ruoyi.fac.service;



import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;

/**
 * 电解槽信息Service接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface IFacElectrolyticCellInfoService
{


//    /**
//     * 查询电解槽信息
//     *
//     * @param facDeviceMetaTemper 电解槽故障
//     * @return 电解槽集合
//     */
//    public List<FacDeviceMetaTemper> selectFacErrorElectrolyticCellList(FacDeviceMetaTemper facDeviceMetaTemper);

    public AjaxResult getElectrolyticCellInfo(FacDeviceMetaSensorData facDeviceMetaSensorData);

}

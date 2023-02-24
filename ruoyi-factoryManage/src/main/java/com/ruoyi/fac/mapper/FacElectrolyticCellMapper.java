package com.ruoyi.fac.mapper;

import java.util.List;
import com.ruoyi.fac.domain.FacElectrolyticCell;
import com.ruoyi.fac.domain.FacEndDevice;

/**
 * 电解槽管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
public interface FacElectrolyticCellMapper 
{
    /**
     * 查询电解槽管理
     * 
     * @param electrolyticcellId 电解槽管理主键
     * @return 电解槽管理
     */
    public FacElectrolyticCell selectFacElectrolyticCellByElectrolyticcellId(Long electrolyticcellId);

    /**
     * 查询电解槽管理列表
     * 
     * @param facElectrolyticCell 电解槽管理
     * @return 电解槽管理集合
     */
    public List<FacElectrolyticCell> selectFacElectrolyticCellList(FacElectrolyticCell facElectrolyticCell);

    /**
     * 新增电解槽管理
     * 
     * @param facElectrolyticCell 电解槽管理
     * @return 结果
     */
    public int insertFacElectrolyticCell(FacElectrolyticCell facElectrolyticCell);

    /**
     * 修改电解槽管理
     * 
     * @param facElectrolyticCell 电解槽管理
     * @return 结果
     */
    public int updateFacElectrolyticCell(FacElectrolyticCell facElectrolyticCell);

    /**
     * 删除电解槽管理
     * 
     * @param electrolyticcellId 电解槽管理主键
     * @return 结果
     */
    public int deleteFacElectrolyticCellByElectrolyticcellId(Long electrolyticcellId);

    /**
     * 批量删除电解槽管理
     * 
     * @param electrolyticcellIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacElectrolyticCellByElectrolyticcellIds(Long[] electrolyticcellIds);

    /**
     * 批量删除设备管理
     * 
     * @param electrolyticcellIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacEndDeviceByElectrolyticellIds(Long[] electrolyticcellIds);
    
    /**
     * 批量新增设备管理
     * 
     * @param facEndDeviceList 设备管理列表
     * @return 结果
     */
    public int batchFacEndDevice(List<FacEndDevice> facEndDeviceList);
    

    /**
     * 通过电解槽管理主键删除设备管理信息
     * 
     * @param electrolyticcellId 电解槽管理ID
     * @return 结果
     */
    public int deleteFacEndDeviceByElectrolyticellId(Long electrolyticcellId);
}

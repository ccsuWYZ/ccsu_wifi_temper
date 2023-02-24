package com.ruoyi.fac.mapper;

import java.util.List;
import com.ruoyi.fac.domain.FacErrorElectrolyticCell;

/**
 * 电解槽故障Mapper接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface FacErrorElectrolyticCellMapper 
{
    /**
     * 查询电解槽故障
     * 
     * @param id 电解槽故障主键
     * @return 电解槽故障
     */
    public FacErrorElectrolyticCell selectFacErrorElectrolyticCellById(Long id);

    /**
     * 查询电解槽故障列表
     * 
     * @param facErrorElectrolyticCell 电解槽故障
     * @return 电解槽故障集合
     */
    public List<FacErrorElectrolyticCell> selectFacErrorElectrolyticCellList(FacErrorElectrolyticCell facErrorElectrolyticCell);

    /**
     * 新增电解槽故障
     * 
     * @param facErrorElectrolyticCell 电解槽故障
     * @return 结果
     */
    public int insertFacErrorElectrolyticCell(FacErrorElectrolyticCell facErrorElectrolyticCell);

    /**
     * 修改电解槽故障
     * 
     * @param facErrorElectrolyticCell 电解槽故障
     * @return 结果
     */
    public int updateFacErrorElectrolyticCell(FacErrorElectrolyticCell facErrorElectrolyticCell);

    /**
     * 删除电解槽故障
     * 
     * @param id 电解槽故障主键
     * @return 结果
     */
    public int deleteFacErrorElectrolyticCellById(Long id);

    /**
     * 批量删除电解槽故障
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacErrorElectrolyticCellByIds(Long[] ids);
}

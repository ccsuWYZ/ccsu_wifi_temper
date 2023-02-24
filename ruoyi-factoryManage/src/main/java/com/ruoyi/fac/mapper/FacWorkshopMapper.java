package com.ruoyi.fac.mapper;

import java.util.List;
import com.ruoyi.fac.domain.FacWorkshop;
import com.ruoyi.fac.domain.FacElectrolyticCell;

/**
 * 生产车间Mapper接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface FacWorkshopMapper 
{
    /**
     * 查询生产车间
     * 
     * @param workshopId 生产车间主键
     * @return 生产车间
     */
    public FacWorkshop selectFacWorkshopByWorkshopId(Long workshopId);

    /**
     * 查询生产车间列表
     * 
     * @param facWorkshop 生产车间
     * @return 生产车间集合
     */
    public List<FacWorkshop> selectFacWorkshopList(FacWorkshop facWorkshop);

    /**
     * 新增生产车间
     * 
     * @param facWorkshop 生产车间
     * @return 结果
     */
    public int insertFacWorkshop(FacWorkshop facWorkshop);

    /**
     * 修改生产车间
     * 
     * @param facWorkshop 生产车间
     * @return 结果
     */
    public int updateFacWorkshop(FacWorkshop facWorkshop);

    /**
     * 删除生产车间
     * 
     * @param workshopId 生产车间主键
     * @return 结果
     */
    public int deleteFacWorkshopByWorkshopId(Long workshopId);

    /**
     * 批量删除生产车间
     * 
     * @param workshopIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacWorkshopByWorkshopIds(Long[] workshopIds);

    /**
     * 批量删除电解槽管理
     * 
     * @param workshopIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacElectrolyticCellByWorkshopIds(Long[] workshopIds);
    
    /**
     * 批量新增电解槽管理
     * 
     * @param facElectrolyticCellList 电解槽管理列表
     * @return 结果
     */
    public int batchFacElectrolyticCell(List<FacElectrolyticCell> facElectrolyticCellList);
    

    /**
     * 通过生产车间主键删除电解槽管理信息
     * 
     * @param workshopId 生产车间ID
     * @return 结果
     */
    public int deleteFacElectrolyticCellByWorkshopId(Long workshopId);
}

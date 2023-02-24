package com.ruoyi.fac.service;

import java.util.List;
import com.ruoyi.fac.domain.FacElectrolyticCell;

/**
 * 电解槽管理Service接口
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
public interface IFacElectrolyticCellService 
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
     * 批量删除电解槽管理
     * 
     * @param electrolyticcellIds 需要删除的电解槽管理主键集合
     * @return 结果
     */
    public int deleteFacElectrolyticCellByElectrolyticcellIds(Long[] electrolyticcellIds);

    /**
     * 删除电解槽管理信息
     * 
     * @param electrolyticcellId 电解槽管理主键
     * @return 结果
     */
    public int deleteFacElectrolyticCellByElectrolyticcellId(Long electrolyticcellId);

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

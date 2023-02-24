package com.ruoyi.fac.service;

import java.util.List;
import com.ruoyi.fac.domain.FacWorkshop;

/**
 * 生产车间Service接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface IFacWorkshopService 
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
     * 批量删除生产车间
     * 
     * @param workshopIds 需要删除的生产车间主键集合
     * @return 结果
     */
    public int deleteFacWorkshopByWorkshopIds(Long[] workshopIds);

    /**
     * 删除生产车间信息
     * 
     * @param workshopId 生产车间主键
     * @return 结果
     */
    public int deleteFacWorkshopByWorkshopId(Long workshopId);


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

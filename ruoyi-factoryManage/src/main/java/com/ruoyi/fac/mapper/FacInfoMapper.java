package com.ruoyi.fac.mapper;

import java.util.List;
import com.ruoyi.fac.domain.FacInfo;
import com.ruoyi.fac.domain.FacWorkshop;

/**
 * 工厂管理Mapper接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface FacInfoMapper 
{
    /**
     * 查询工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 工厂管理
     */
    public FacInfo selectFacInfoByFactoryId(Long factoryId);

    /**
     * 查询工厂管理列表
     * 
     * @param facInfo 工厂管理
     * @return 工厂管理集合
     */
    public List<FacInfo> selectFacInfoList(FacInfo facInfo);

    /**
     * 新增工厂管理
     * 
     * @param facInfo 工厂管理
     * @return 结果
     */
    public int insertFacInfo(FacInfo facInfo);

    /**
     * 修改工厂管理
     * 
     * @param facInfo 工厂管理
     * @return 结果
     */
    public int updateFacInfo(FacInfo facInfo);

    /**
     * 删除工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 结果
     */
    public int deleteFacInfoByFactoryId(Long factoryId);

    /**
     * 批量删除工厂管理
     * 
     * @param factoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacInfoByFactoryIds(Long[] factoryIds);

    /**
     * 批量删除生产车间
     * 
     * @param factoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacWorkshopByFactoryIds(Long[] factoryIds);
    
    /**
     * 批量新增生产车间
     * 
     * @param facWorkshopList 生产车间列表
     * @return 结果
     */
    public int batchFacWorkshop(List<FacWorkshop> facWorkshopList);
    

    /**
     * 通过工厂管理主键删除生产车间信息
     * 
     * @param factoryId 工厂管理ID
     * @return 结果
     */
    public int deleteFacWorkshopByFactoryId(Long factoryId);
}

package com.ruoyi.fac.service;

import java.util.List;
import com.ruoyi.fac.domain.FacInfo;

/**
 * 工厂管理Service接口
 * 
 * @author ccsu
 * @date 2022-11-22
 */
public interface IFacInfoService 
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
     * 批量删除工厂管理
     * 
     * @param factoryIds 需要删除的工厂管理主键集合
     * @return 结果
     */
    public int deleteFacInfoByFactoryIds(Long[] factoryIds);

    /**
     * 删除工厂管理信息
     * 
     * @param factoryId 工厂管理主键
     * @return 结果
     */
    public int deleteFacInfoByFactoryId(Long factoryId);

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

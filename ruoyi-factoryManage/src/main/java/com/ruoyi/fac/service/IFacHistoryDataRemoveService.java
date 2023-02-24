package com.ruoyi.fac.service;

/**
 * @author lee
 * @date 2023-02-23 20:51:39
 * @description
 */
public interface IFacHistoryDataRemoveService {
    /*备份xx天之前的数据*/
    public void backUpData(Integer days);

    /*删除xx天之前的数据*/
    public void removeData(Integer days);
}

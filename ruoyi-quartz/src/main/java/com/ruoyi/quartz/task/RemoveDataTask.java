package com.ruoyi.quartz.task;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.fac.service.IFacHistoryDataRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 历史数据迁移任务
 *
 * @author lee
 * @date 2023-02-23 20:49:36
 * @description
 */
@Component("RemoveDataTask")
public class RemoveDataTask {
    @Autowired
    private IFacHistoryDataRemoveService iFacHistoryDataRemoveService;
    @Autowired
    private RedisCache redisCache;

    public void removeHistoryData() {
        Integer days = Integer.valueOf(redisCache.getCacheObject(CacheConstants.SYS_CONFIG_KEY + "fac.data.days"));
        System.out.println("备份xx天之前的数据");
        iFacHistoryDataRemoveService.backUpData(days);
        System.out.println("删除xx天之前的数据");
        iFacHistoryDataRemoveService.removeData(days);
    }
}

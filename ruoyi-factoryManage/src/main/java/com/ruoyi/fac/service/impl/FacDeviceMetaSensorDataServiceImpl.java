package com.ruoyi.fac.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.fac.domain.FacDeviceMetaTemper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fac.mapper.FacDeviceMetaSensorDataMapper;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.service.IFacDeviceMetaSensorDataService;

import javax.servlet.http.HttpServletRequest;

/**
 * 传感器数据Service业务层处理
 * 
 * @author ccsu
 * @date 2023-01-13
 */
@Service
public class FacDeviceMetaSensorDataServiceImpl implements IFacDeviceMetaSensorDataService 
{
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private FacDeviceMetaSensorDataMapper facDeviceMetaSensorDataMapper;
    @Autowired
    private HttpServletRequest request;
    /**
     * 查询传感器数据
     * 
     * @param sensorDataId 传感器数据主键
     * @return 传感器数据
     */
    @Override
    public FacDeviceMetaSensorData selectFacDeviceMetaSensorDataBySensorDataId(Integer sensorDataId)
    {
        return facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataBySensorDataId(sensorDataId);
    }

    /**
     * 查询传感器数据列表
     * 
     * @param facDeviceMetaSensorData 传感器数据
     * @return 传感器数据
     */
    @Override
    public List<FacDeviceMetaSensorData> selectFacDeviceMetaSensorDataList(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
//        if ("temper".equals(facDeviceMetaSensorData.getType())||"voltage".equals(facDeviceMetaSensorData.getType())){
            String beginTime = request.getParameter("params[beginAcquisitionTime]");
            String endTime = request.getParameter("params[endAcquisitionTime]");
            if (beginTime == null && endTime == null) {//传入的时间为空，默认取全部的现在的数据
                System.out.println("时间为空");
                return facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
            } else {
                //创建日期时间对象格式化器，日期格式类似： 2020-02-23 22:18:38
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                //将时间格式字符串转化为LocalDateTime对象，需传入日期对象格式化器
                LocalDateTime parseBeginDate = LocalDateTime.parse(beginTime, formatter);
                LocalDateTime parseEndDate = LocalDateTime.parse(endTime, formatter);
                LocalDateTime now = LocalDateTime.now();
                int history_data= Integer.valueOf(redisCache.getCacheObject(CacheConstants.SYS_CONFIG_KEY+"fac.data.days")) ;
                LocalDateTime now_day = now.minusDays(history_data);

                if (parseEndDate.isBefore(now_day)) {
                    System.out.println("全是历史数据");
                    return facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList_history(facDeviceMetaSensorData);

                } else if (parseBeginDate.isAfter(now_day)) {
                    System.out.println("全是新数据");
                    return facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
                }else if (parseBeginDate.isBefore(now_day)&&parseEndDate.isAfter(now_day)){
                    System.out.println("历史数据+新数据");
                    List<FacDeviceMetaSensorData> facDeviceMetaSensorDataList=facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
                    List<FacDeviceMetaSensorData> facDeviceMetaSensorDataList_history=facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList_history(facDeviceMetaSensorData);
                    facDeviceMetaSensorDataList.addAll(facDeviceMetaSensorDataList_history);
                    return facDeviceMetaSensorDataList;

                }
            }
//        }else {
//            return facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
//        }
        return null;
    }

    /**
     * 新增传感器数据
     * 
     * @param facDeviceMetaSensorData 传感器数据
     * @return 结果
     */
    @Override
    public int insertFacDeviceMetaSensorData(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return facDeviceMetaSensorDataMapper.insertFacDeviceMetaSensorData(facDeviceMetaSensorData);
    }

    /**
     * 修改传感器数据
     * 
     * @param facDeviceMetaSensorData 传感器数据
     * @return 结果
     */
    @Override
    public int updateFacDeviceMetaSensorData(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return facDeviceMetaSensorDataMapper.updateFacDeviceMetaSensorData(facDeviceMetaSensorData);
    }

    /**
     * 批量删除传感器数据
     * 
     * @param sensorDataIds 需要删除的传感器数据主键
     * @return 结果
     */
    @Override
    public int deleteFacDeviceMetaSensorDataBySensorDataIds(Integer[] sensorDataIds)
    {
        return facDeviceMetaSensorDataMapper.deleteFacDeviceMetaSensorDataBySensorDataIds(sensorDataIds);
    }

    /**
     * 删除传感器数据信息
     * 
     * @param sensorDataId 传感器数据主键
     * @return 结果
     */
    @Override
    public int deleteFacDeviceMetaSensorDataBySensorDataId(Integer sensorDataId)
    {
        return facDeviceMetaSensorDataMapper.deleteFacDeviceMetaSensorDataBySensorDataId(sensorDataId);
    }
}

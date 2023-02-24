package com.ruoyi.fac.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fac.mapper.FacDeviceMetaTemperMapper;
import com.ruoyi.fac.domain.FacDeviceMetaTemper;
import com.ruoyi.fac.service.IFacDeviceMetaTemperService;

import javax.servlet.http.HttpServletRequest;

/**
 * 温度管理Service业务层处理
 *
 * @author ccsu
 * @date 2022-12-27
 */
@Service
public class FacDeviceMetaTemperServiceImpl implements IFacDeviceMetaTemperService {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FacDeviceMetaTemperMapper facDeviceMetaTemperMapper;

    /**
     * 查询温度管理
     *
     * @param temperId 温度管理主键
     * @return 温度管理
     */
    @Override
    public FacDeviceMetaTemper selectFacDeviceMetaTemperByTemperId(Long temperId) {
        return facDeviceMetaTemperMapper.selectFacDeviceMetaTemperByTemperId(temperId);
    }

    /**
     * 查询温度管理列表
     *
     * @param facDeviceMetaTemper 温度管理
     * @return 温度管理
     */
    @Override
    public List<FacDeviceMetaTemper> selectFacDeviceMetaTemperList(FacDeviceMetaTemper facDeviceMetaTemper) {
        String beginTime = request.getParameter("params[beginAcquisitionTime]");
        String endTime = request.getParameter("params[endAcquisitionTime]");
        if (beginTime == null && endTime == null) {
            System.out.println("时间为空");
            return facDeviceMetaTemperMapper.selectFacDeviceMetaTemperList(facDeviceMetaTemper);
        } else {
            //创建日期时间对象格式化器，日期格式类似： 2020-02-23 22:18:38
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            //将时间格式字符串转化为LocalDateTime对象，需传入日期对象格式化器
            LocalDateTime parseBeginDate = LocalDateTime.parse(beginTime, formatter);
            LocalDateTime parseEndDate = LocalDateTime.parse(endTime, formatter);
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime now_15 = now.minusDays(15);

            if (parseEndDate.isBefore(now_15)) {
                System.out.println("全是历史数据");
                return facDeviceMetaTemperMapper.selectFacDeviceMetaTemper_history_List(facDeviceMetaTemper);

            } else if (parseBeginDate.isAfter(now_15)) {
                System.out.println("全是新数据");
                return facDeviceMetaTemperMapper.selectFacDeviceMetaTemperList(facDeviceMetaTemper);
            }else if (parseBeginDate.isBefore(now_15)&&parseEndDate.isAfter(now_15)){
                System.out.println("历史数据+新数据");
                List<FacDeviceMetaTemper> facDeviceMetaTemperList=facDeviceMetaTemperMapper.selectFacDeviceMetaTemperList(facDeviceMetaTemper);
                List<FacDeviceMetaTemper> facDeviceMetaTemperList_history=facDeviceMetaTemperMapper.selectFacDeviceMetaTemper_history_List(facDeviceMetaTemper);
                facDeviceMetaTemperList.addAll(facDeviceMetaTemperList_history);
            return facDeviceMetaTemperList;

            }
        }
        return null;
    }

    /**
     * 新增温度管理
     *
     * @param facDeviceMetaTemper 温度管理
     * @return 结果
     */
    @Override
    public int insertFacDeviceMetaTemper(FacDeviceMetaTemper facDeviceMetaTemper) {
        return facDeviceMetaTemperMapper.insertFacDeviceMetaTemper(facDeviceMetaTemper);
    }

    /**
     * 修改温度管理
     *
     * @param facDeviceMetaTemper 温度管理
     * @return 结果
     */
    @Override
    public int updateFacDeviceMetaTemper(FacDeviceMetaTemper facDeviceMetaTemper) {
        return facDeviceMetaTemperMapper.updateFacDeviceMetaTemper(facDeviceMetaTemper);
    }

    /**
     * 批量删除温度管理
     *
     * @param temperIds 需要删除的温度管理主键
     * @return 结果
     */
    @Override
    public int deleteFacDeviceMetaTemperByTemperIds(Long[] temperIds) {
        return facDeviceMetaTemperMapper.deleteFacDeviceMetaTemperByTemperIds(temperIds);
    }

    /**
     * 删除温度管理信息
     *
     * @param temperId 温度管理主键
     * @return 结果
     */
    @Override
    public int deleteFacDeviceMetaTemperByTemperId(Long temperId) {
        return facDeviceMetaTemperMapper.deleteFacDeviceMetaTemperByTemperId(temperId);
    }
}

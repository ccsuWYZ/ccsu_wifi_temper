package com.ruoyi.fac.service.impl;

import java.util.*;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.domain.FacElectrolyticCell;
import com.ruoyi.fac.mapper.FacDeviceMetaSensorDataMapper;
import com.ruoyi.fac.mapper.FacElectrolyticCellMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fac.service.IFacElectrolyticCellInfoService;

/**
 * 电解槽信息Service业务层处理
 *
 * @author ccsu
 * @date 2022-11-22
 */
@Service
public class FacElectrolyticCellInfoServiceImpl implements IFacElectrolyticCellInfoService {
    @Autowired
    private FacDeviceMetaSensorDataMapper facDeviceMetaSensorDataMapper;
    @Autowired
    private FacElectrolyticCellMapper facElectrolyticCellMapper;
    @Autowired
    private RedisCache redisCache;

    @Override
    public AjaxResult getElectrolyticCellInfo(FacDeviceMetaSensorData facDeviceMetaSensorData) {
        List<FacDeviceMetaSensorData> facDeviceMetaTemperList = facDeviceMetaSensorDataMapper.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
        List<FacElectrolyticCell> facElectrolyticCellList = facElectrolyticCellMapper.selectFacElectrolyticCellList(new FacElectrolyticCell());
        Integer temp1 = Integer.parseInt(redisCache.getCacheObject(CacheConstants.SYS_CONFIG_KEY + "fac.temper.temp1"));
        Integer temp2 = Integer.parseInt(redisCache.getCacheObject(CacheConstants.SYS_CONFIG_KEY + "fac.temper.temp2"));
        Integer temp;
        HashSet<Long> warningElectronicId = new HashSet<>();
        HashSet<Long> errorElectronicId = new HashSet<>();
        HashSet<Long> normalElectronicId = new HashSet<>();
        HashSet<Long> allElectronicId = new HashSet<>();
        System.out.println(facDeviceMetaTemperList.size());
        for (FacDeviceMetaSensorData facDeviceMetaTemper1 : facDeviceMetaTemperList) {
            if ("null".equals(facDeviceMetaTemper1.getValue()))continue;
            temp = Integer.valueOf(facDeviceMetaTemper1.getValue());
            if (temp > temp1 && temp < temp2) {
                warningElectronicId.add(facDeviceMetaTemper1.getElectrolyticCellId());
            }
            if (temp >= temp2) {
                errorElectronicId.add(facDeviceMetaTemper1.getElectrolyticCellId());
            }
        }
        for (FacElectrolyticCell facElectrolyticCell : facElectrolyticCellList) {
            allElectronicId.add(facElectrolyticCell.getElectrolyticcellId());
        }
        Map<String, Object> res = new HashMap<>();
        normalElectronicId.addAll(allElectronicId);
      for (Long errorI:errorElectronicId){
          for (Long warnI:warningElectronicId){
              if (errorI.longValue()==warnI.longValue() ){
                  warningElectronicId.remove(warnI);
              }
          }
      }
        normalElectronicId.removeAll(errorElectronicId);
        normalElectronicId.removeAll(warningElectronicId);
        System.out.println("故障：");
        System.out.println(errorElectronicId);
        System.out.println("预警：");
        System.out.println(warningElectronicId);
        System.out.println("正常：");
        System.out.println(normalElectronicId);
        res.put("all", allElectronicId);
        res.put("normal", normalElectronicId);
        res.put("error", errorElectronicId);
        res.put("warning", warningElectronicId);
        return new AjaxResult(200, "返回的电解槽信息", res);
    }

}

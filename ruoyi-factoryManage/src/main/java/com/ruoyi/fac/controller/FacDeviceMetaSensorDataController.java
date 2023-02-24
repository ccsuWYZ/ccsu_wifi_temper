package com.ruoyi.fac.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fac.domain.FacDeviceMetaSensorData;
import com.ruoyi.fac.service.IFacDeviceMetaSensorDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 传感器数据管理
 * 
 * @author ccsu
 * @date 2023-01-13
 */
@RestController
@RequestMapping("/fac/sensor")
public class FacDeviceMetaSensorDataController extends BaseController
{
    @Autowired
    private IFacDeviceMetaSensorDataService facDeviceMetaSensorDataService;

    /**
     * 查询传感器数据列表
     */
    @PreAuthorize("@ss.hasPermi('fac:sensor:list')")
    @GetMapping("/list")
    public TableDataInfo list(FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        startPage();
        List<FacDeviceMetaSensorData> list = facDeviceMetaSensorDataService.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
        return getDataTable(list);
    }

    /**
     * 导出传感器数据列表
     */
    @PreAuthorize("@ss.hasPermi('fac:sensor:export')")
    @Log(title = "传感器数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        List<FacDeviceMetaSensorData> list = facDeviceMetaSensorDataService.selectFacDeviceMetaSensorDataList(facDeviceMetaSensorData);
        ExcelUtil<FacDeviceMetaSensorData> util = new ExcelUtil<FacDeviceMetaSensorData>(FacDeviceMetaSensorData.class);
        util.exportExcel(response, list, "传感器数据数据");
    }

    /**
     * 获取传感器数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('fac:sensor:query')")
    @GetMapping(value = "/{sensorDataId}")
    public AjaxResult getInfo(@PathVariable("sensorDataId") Integer sensorDataId)
    {
        return AjaxResult.success(facDeviceMetaSensorDataService.selectFacDeviceMetaSensorDataBySensorDataId(sensorDataId));
    }

    /**
     * 新增传感器数据
     */
    @PreAuthorize("@ss.hasPermi('fac:sensor:add')")
    @Log(title = "传感器数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return toAjax(facDeviceMetaSensorDataService.insertFacDeviceMetaSensorData(facDeviceMetaSensorData));
    }

    /**
     * 修改传感器数据
     */
    @PreAuthorize("@ss.hasPermi('fac:sensor:edit')")
    @Log(title = "传感器数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FacDeviceMetaSensorData facDeviceMetaSensorData)
    {
        return toAjax(facDeviceMetaSensorDataService.updateFacDeviceMetaSensorData(facDeviceMetaSensorData));
    }

    /**
     * 删除传感器数据
     */
    @PreAuthorize("@ss.hasPermi('fac:sensor:remove')")
    @Log(title = "传感器数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sensorDataIds}")
    public AjaxResult remove(@PathVariable Integer[] sensorDataIds)
    {
        return toAjax(facDeviceMetaSensorDataService.deleteFacDeviceMetaSensorDataBySensorDataIds(sensorDataIds));
    }
}

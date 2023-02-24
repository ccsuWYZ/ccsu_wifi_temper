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
import com.ruoyi.fac.domain.FacEndDevice;
import com.ruoyi.fac.service.IFacEndDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备管理
 * 
 * @author ccsu
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/fac/device")
public class FacEndDeviceController extends BaseController
{
    @Autowired
    private IFacEndDeviceService facEndDeviceService;

    /**
     * 查询设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('fac:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(FacEndDevice facEndDevice)
    {
        startPage();
        List<FacEndDevice> list = facEndDeviceService.selectFacEndDeviceList(facEndDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('fac:device:export')")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FacEndDevice facEndDevice)
    {
        List<FacEndDevice> list = facEndDeviceService.selectFacEndDeviceList(facEndDevice);
        ExcelUtil<FacEndDevice> util = new ExcelUtil<FacEndDevice>(FacEndDevice.class);
        util.exportExcel(response, list, "设备管理数据");
    }

    /**
     * 获取设备管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fac:device:query')")
    @GetMapping(value = "/{deviceId}")
    public AjaxResult getInfo(@PathVariable("deviceId") String deviceId)
    {
        return AjaxResult.success(facEndDeviceService.selectFacEndDeviceByDeviceId(deviceId));
    }

    /**
     * 新增设备管理
     */
    @PreAuthorize("@ss.hasPermi('fac:device:add')")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FacEndDevice facEndDevice)
    {
        return toAjax(facEndDeviceService.insertFacEndDevice(facEndDevice));
    }

    /**
     * 修改设备管理
     */
    @PreAuthorize("@ss.hasPermi('fac:device:edit')")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FacEndDevice facEndDevice)
    {
        return toAjax(facEndDeviceService.updateFacEndDevice(facEndDevice));
    }

    /**
     * 删除设备管理
     */
    @PreAuthorize("@ss.hasPermi('fac:device:remove')")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deviceIds}")
    public AjaxResult remove(@PathVariable String[] deviceIds)
    {
        return toAjax(facEndDeviceService.deleteFacEndDeviceByDeviceIds(deviceIds));
    }
}

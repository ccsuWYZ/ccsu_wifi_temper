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
import com.ruoyi.fac.domain.FacInfo;
import com.ruoyi.fac.service.IFacInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工厂管理
 * 
 * @author ccsu
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/fac/factory")
public class FacInfoController extends BaseController
{
    @Autowired
    private IFacInfoService facInfoService;

    /**
     * 查询工厂管理列表
     */
    @PreAuthorize("@ss.hasPermi('fac:factory:list')")
    @GetMapping("/list")
    public TableDataInfo list(FacInfo facInfo)
    {
        startPage();
        List<FacInfo> list = facInfoService.selectFacInfoList(facInfo);
        return getDataTable(list);
    }

    /**
     * 导出工厂管理列表
     */
    @PreAuthorize("@ss.hasPermi('fac:factory:export')")
    @Log(title = "工厂管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FacInfo facInfo)
    {
        List<FacInfo> list = facInfoService.selectFacInfoList(facInfo);
        ExcelUtil<FacInfo> util = new ExcelUtil<FacInfo>(FacInfo.class);
        util.exportExcel(response, list, "工厂管理数据");
    }

    /**
     * 获取工厂管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fac:factory:query')")
    @GetMapping(value = "/{factoryId}")
    public AjaxResult getInfo(@PathVariable("factoryId") Long factoryId)
    {
        return AjaxResult.success(facInfoService.selectFacInfoByFactoryId(factoryId));
    }

    /**
     * 新增工厂管理
     */
    @PreAuthorize("@ss.hasPermi('fac:factory:add')")
    @Log(title = "工厂管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FacInfo facInfo)
    {
        return toAjax(facInfoService.insertFacInfo(facInfo));
    }

    /**
     * 修改工厂管理
     */
    @PreAuthorize("@ss.hasPermi('fac:factory:edit')")
    @Log(title = "工厂管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FacInfo facInfo)
    {
        return toAjax(facInfoService.updateFacInfo(facInfo));
    }

    /**
     * 删除工厂管理
     */
    @PreAuthorize("@ss.hasPermi('fac:factory:remove')")
    @Log(title = "工厂管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{factoryIds}")
    public AjaxResult remove(@PathVariable Long[] factoryIds)
    {
        return toAjax(facInfoService.deleteFacInfoByFactoryIds(factoryIds));
    }
}

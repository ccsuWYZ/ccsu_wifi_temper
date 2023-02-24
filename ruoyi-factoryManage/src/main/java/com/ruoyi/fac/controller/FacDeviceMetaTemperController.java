//package com.ruoyi.fac.controller;
//
//import java.util.List;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ruoyi.common.annotation.Anonymous;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.ruoyi.common.annotation.Log;
//import com.ruoyi.common.core.controller.BaseController;
//import com.ruoyi.common.core.domain.AjaxResult;
//import com.ruoyi.common.enums.BusinessType;
//import com.ruoyi.fac.domain.FacDeviceMetaTemper;
//import com.ruoyi.fac.service.IFacDeviceMetaTemperService;
//import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.ruoyi.common.core.page.TableDataInfo;
//
///**
// * 温度管理Controller
// *
// * @author ccsu
// * @date 2022-11-23
// */
//@RestController
//@RequestMapping("/fac/temper")
//public class FacDeviceMetaTemperController extends BaseController
//{
//    @Autowired
//    private IFacDeviceMetaTemperService facDeviceMetaTemperService;
//
//    /**
//     * 查询温度管理列表
//     */
//    @PreAuthorize("@ss.hasPermi('fac:temper:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(FacDeviceMetaTemper facDeviceMetaTemper)
//    {
//        startPage();
//        List<FacDeviceMetaTemper> list = facDeviceMetaTemperService.selectFacDeviceMetaTemperList(facDeviceMetaTemper);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出温度管理列表
//     */
//    @PreAuthorize("@ss.hasPermi('fac:temper:export')")
//    @Log(title = "温度管理", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, FacDeviceMetaTemper facDeviceMetaTemper)
//    {
//        List<FacDeviceMetaTemper> list = facDeviceMetaTemperService.selectFacDeviceMetaTemperList(facDeviceMetaTemper);
//        ExcelUtil<FacDeviceMetaTemper> util = new ExcelUtil<FacDeviceMetaTemper>(FacDeviceMetaTemper.class);
//        util.exportExcel(response, list, "温度管理数据");
//    }
//
//    /**
//     * 获取温度管理详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('fac:temper:query')")
//    @GetMapping(value = "/{temperId}")
//    public AjaxResult getInfo(@PathVariable("temperId") Long temperId)
//    {
//        return AjaxResult.success(facDeviceMetaTemperService.selectFacDeviceMetaTemperByTemperId(temperId));
//    }
//
//    /**
//     * 新增温度管理
//     */
//    @PreAuthorize("@ss.hasPermi('fac:temper:add')")
//    @Log(title = "温度管理", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody FacDeviceMetaTemper facDeviceMetaTemper)
//    {
//        return toAjax(facDeviceMetaTemperService.insertFacDeviceMetaTemper(facDeviceMetaTemper));
//    }
//
//    /**
//     * 修改温度管理
//     */
//    @PreAuthorize("@ss.hasPermi('fac:temper:edit')")
//    @Log(title = "温度管理", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody FacDeviceMetaTemper facDeviceMetaTemper)
//    {
//        return toAjax(facDeviceMetaTemperService.updateFacDeviceMetaTemper(facDeviceMetaTemper));
//    }
//
//    /**
//     * 删除温度管理
//     */
//    @PreAuthorize("@ss.hasPermi('fac:temper:remove')")
//    @Log(title = "温度管理", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{temperIds}")
//    public AjaxResult remove(@PathVariable Long[] temperIds)
//    {
//        return toAjax(facDeviceMetaTemperService.deleteFacDeviceMetaTemperByTemperIds(temperIds));
//    }
//}

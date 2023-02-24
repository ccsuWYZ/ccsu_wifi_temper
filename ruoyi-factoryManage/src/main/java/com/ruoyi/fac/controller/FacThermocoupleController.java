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
import com.ruoyi.fac.domain.FacThermocouple;
import com.ruoyi.fac.service.IFacThermocoupleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 热电偶管理
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/fac/thermocouple")
public class FacThermocoupleController extends BaseController
{
    @Autowired
    private IFacThermocoupleService facThermocoupleService;

    /**
     * 查询热电偶列表
     */
    @PreAuthorize("@ss.hasPermi('fac:thermocouple:list')")
    @GetMapping("/list")
    public TableDataInfo list(FacThermocouple facThermocouple)
    {
        startPage();
        List<FacThermocouple> list = facThermocoupleService.selectFacThermocoupleList(facThermocouple);
        return getDataTable(list);
    }

    /**
     * 导出热电偶列表
     */
    @PreAuthorize("@ss.hasPermi('fac:thermocouple:export')")
    @Log(title = "热电偶", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FacThermocouple facThermocouple)
    {
        List<FacThermocouple> list = facThermocoupleService.selectFacThermocoupleList(facThermocouple);
        ExcelUtil<FacThermocouple> util = new ExcelUtil<FacThermocouple>(FacThermocouple.class);
        util.exportExcel(response, list, "热电偶数据");
    }

    /**
     * 获取热电偶详细信息
     */
    @PreAuthorize("@ss.hasPermi('fac:thermocouple:query')")
    @GetMapping(value = "/{thermocoupleId}")
    public AjaxResult getInfo(@PathVariable("thermocoupleId") String thermocoupleId)
    {
        return AjaxResult.success(facThermocoupleService.selectFacThermocoupleByThermocoupleId(thermocoupleId));
    }

    /**
     * 新增热电偶
     */
    @PreAuthorize("@ss.hasPermi('fac:thermocouple:add')")
    @Log(title = "热电偶", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FacThermocouple facThermocouple)
    {
        return toAjax(facThermocoupleService.insertFacThermocouple(facThermocouple));
    }

    /**
     * 修改热电偶
     */
    @PreAuthorize("@ss.hasPermi('fac:thermocouple:edit')")
    @Log(title = "热电偶", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FacThermocouple facThermocouple)
    {
        return toAjax(facThermocoupleService.updateFacThermocouple(facThermocouple));
    }

    /**
     * 删除热电偶
     */
    @PreAuthorize("@ss.hasPermi('fac:thermocouple:remove')")
    @Log(title = "热电偶", businessType = BusinessType.DELETE)
	@DeleteMapping("/{thermocoupleIds}")
    public AjaxResult remove(@PathVariable String[] thermocoupleIds)
    {
        return toAjax(facThermocoupleService.deleteFacThermocoupleByThermocoupleIds(thermocoupleIds));
    }
}

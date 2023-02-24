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
import com.ruoyi.fac.domain.FacWorkshop;
import com.ruoyi.fac.service.IFacWorkshopService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产车间管理
 * 
 * @author ccsu
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/fac/workshop")
public class FacWorkshopController extends BaseController
{
    @Autowired
    private IFacWorkshopService facWorkshopService;

    /**
     * 查询生产车间列表
     */
    @PreAuthorize("@ss.hasPermi('fac:workshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(FacWorkshop facWorkshop)
    {
        startPage();
        List<FacWorkshop> list = facWorkshopService.selectFacWorkshopList(facWorkshop);
        return getDataTable(list);
    }

    /**
     * 导出生产车间列表
     */
    @PreAuthorize("@ss.hasPermi('fac:workshop:export')")
    @Log(title = "生产车间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FacWorkshop facWorkshop)
    {
        List<FacWorkshop> list = facWorkshopService.selectFacWorkshopList(facWorkshop);
        ExcelUtil<FacWorkshop> util = new ExcelUtil<FacWorkshop>(FacWorkshop.class);
        util.exportExcel(response, list, "生产车间数据");
    }

    /**
     * 获取生产车间详细信息
     */
    @PreAuthorize("@ss.hasPermi('fac:workshop:query')")
    @GetMapping(value = "/{workshopId}")
    public AjaxResult getInfo(@PathVariable("workshopId") Long workshopId)
    {
        return AjaxResult.success(facWorkshopService.selectFacWorkshopByWorkshopId(workshopId));
    }

    /**
     * 新增生产车间
     */
    @PreAuthorize("@ss.hasPermi('fac:workshop:add')")
    @Log(title = "生产车间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FacWorkshop facWorkshop)
    {
        return toAjax(facWorkshopService.insertFacWorkshop(facWorkshop));
    }

    /**
     * 修改生产车间
     */
    @PreAuthorize("@ss.hasPermi('fac:workshop:edit')")
    @Log(title = "生产车间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FacWorkshop facWorkshop)
    {
        return toAjax(facWorkshopService.updateFacWorkshop(facWorkshop));
    }

    /**
     * 删除生产车间
     */
    @PreAuthorize("@ss.hasPermi('fac:workshop:remove')")
    @Log(title = "生产车间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{workshopIds}")
    public AjaxResult remove(@PathVariable Long[] workshopIds)
    {
        return toAjax(facWorkshopService.deleteFacWorkshopByWorkshopIds(workshopIds));
    }
}

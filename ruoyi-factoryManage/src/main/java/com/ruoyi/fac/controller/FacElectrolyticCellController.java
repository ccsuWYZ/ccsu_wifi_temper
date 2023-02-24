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
import com.ruoyi.fac.domain.FacElectrolyticCell;
import com.ruoyi.fac.service.IFacElectrolyticCellService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电解槽管理
 * 
 * @author ruoyi
 * @date 2022-11-22
 */
@RestController
@RequestMapping("/fac/cell")
public class FacElectrolyticCellController extends BaseController
{
    @Autowired
    private IFacElectrolyticCellService facElectrolyticCellService;

    /**
     * 查询电解槽管理列表
     */
    @PreAuthorize("@ss.hasPermi('fac:cell:list')")
    @GetMapping("/list")
    public TableDataInfo list(FacElectrolyticCell facElectrolyticCell)
    {
        startPage();
        List<FacElectrolyticCell> list = facElectrolyticCellService.selectFacElectrolyticCellList(facElectrolyticCell);
        return getDataTable(list);
    }

    /**
     * 导出电解槽管理列表
     */
    @PreAuthorize("@ss.hasPermi('fac:cell:export')")
    @Log(title = "电解槽管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FacElectrolyticCell facElectrolyticCell)
    {
        List<FacElectrolyticCell> list = facElectrolyticCellService.selectFacElectrolyticCellList(facElectrolyticCell);
        ExcelUtil<FacElectrolyticCell> util = new ExcelUtil<FacElectrolyticCell>(FacElectrolyticCell.class);
        util.exportExcel(response, list, "电解槽管理数据");
    }

    /**
     * 获取电解槽管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fac:cell:query')")
    @GetMapping(value = "/{electrolyticcellId}")
    public AjaxResult getInfo(@PathVariable("electrolyticcellId") Long electrolyticcellId)
    {
        return AjaxResult.success(facElectrolyticCellService.selectFacElectrolyticCellByElectrolyticcellId(electrolyticcellId));
    }

    /**
     * 新增电解槽管理
     */
    @PreAuthorize("@ss.hasPermi('fac:cell:add')")
    @Log(title = "电解槽管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FacElectrolyticCell facElectrolyticCell)
    {
        return toAjax(facElectrolyticCellService.insertFacElectrolyticCell(facElectrolyticCell));
    }

    /**
     * 修改电解槽管理
     */
    @PreAuthorize("@ss.hasPermi('fac:cell:edit')")
    @Log(title = "电解槽管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FacElectrolyticCell facElectrolyticCell)
    {
        return toAjax(facElectrolyticCellService.updateFacElectrolyticCell(facElectrolyticCell));
    }

    /**
     * 删除电解槽管理
     */
    @PreAuthorize("@ss.hasPermi('fac:cell:remove')")
    @Log(title = "电解槽管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{electrolyticcellIds}")
    public AjaxResult remove(@PathVariable Long[] electrolyticcellIds)
    {
        return toAjax(facElectrolyticCellService.deleteFacElectrolyticCellByElectrolyticcellIds(electrolyticcellIds));
    }
}

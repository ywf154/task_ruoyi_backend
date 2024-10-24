package com.ruoyi.task.controller;

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
import com.ruoyi.task.domain.Plate;
import com.ruoyi.task.service.IPlateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务板块Controller
 * 
 * @author yi
 * @date 2024-10-23
 */
@RestController
@RequestMapping("/task/plate")
public class PlateController extends BaseController
{
    @Autowired
    private IPlateService plateService;

    /**
     * 查询任务板块列表
     */
    @PreAuthorize("@ss.hasPermi('task:plate:list')")
    @GetMapping("/list")
    public TableDataInfo list(Plate plate)
    {
        startPage();
        List<Plate> list = plateService.selectPlateList(plate);
        return getDataTable(list);
    }

    /**
     * 导出任务板块列表
     */
    @PreAuthorize("@ss.hasPermi('task:plate:export')")
    @Log(title = "任务板块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Plate plate)
    {
        List<Plate> list = plateService.selectPlateList(plate);
        ExcelUtil<Plate> util = new ExcelUtil<Plate>(Plate.class);
        util.exportExcel(response, list, "任务板块数据");
    }

    /**
     * 获取任务板块详细信息
     */
    @PreAuthorize("@ss.hasPermi('task:plate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(plateService.selectPlateById(id));
    }

    /**
     * 新增任务板块
     */
    @PreAuthorize("@ss.hasPermi('task:plate:add')")
    @Log(title = "任务板块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Plate plate)
    {
        return toAjax(plateService.insertPlate(plate));
    }

    /**
     * 修改任务板块
     */
    @PreAuthorize("@ss.hasPermi('task:plate:edit')")
    @Log(title = "任务板块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Plate plate)
    {
        return toAjax(plateService.updatePlate(plate));
    }

    /**
     * 删除任务板块
     */
    @PreAuthorize("@ss.hasPermi('task:plate:remove')")
    @Log(title = "任务板块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(plateService.deletePlateByIds(ids));
    }
}

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
import com.ruoyi.task.domain.Type;
import com.ruoyi.task.service.ITypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务类型Controller
 * 
 * @author yi
 * @date 2024-10-23
 */
@RestController
@RequestMapping("/task/type")
public class TypeController extends BaseController
{
    @Autowired
    private ITypeService typeService;

    /**
     * 查询任务类型列表
     */
    @PreAuthorize("@ss.hasPermi('task:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(Type type)
    {
        startPage();
        List<Type> list = typeService.selectTypeList(type);
        return getDataTable(list);
    }

    /**
     * 导出任务类型列表
     */
    @PreAuthorize("@ss.hasPermi('task:type:export')")
    @Log(title = "任务类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Type type)
    {
        List<Type> list = typeService.selectTypeList(type);
        ExcelUtil<Type> util = new ExcelUtil<Type>(Type.class);
        util.exportExcel(response, list, "任务类型数据");
    }

    /**
     * 获取任务类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('task:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(typeService.selectTypeById(id));
    }

    /**
     * 新增任务类型
     */
    @PreAuthorize("@ss.hasPermi('task:type:add')")
    @Log(title = "任务类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Type type)
    {
        return toAjax(typeService.insertType(type));
    }

    /**
     * 修改任务类型
     */
    @PreAuthorize("@ss.hasPermi('task:type:edit')")
    @Log(title = "任务类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Type type)
    {
        return toAjax(typeService.updateType(type));
    }

    /**
     * 删除任务类型
     */
    @PreAuthorize("@ss.hasPermi('task:type:remove')")
    @Log(title = "任务类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(typeService.deleteTypeByIds(ids));
    }
}

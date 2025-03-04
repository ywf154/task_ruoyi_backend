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
import com.ruoyi.task.domain.Task;
import com.ruoyi.task.service.ITaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务Controller
 * 
 * @author yi
 * @date 2024-10-23
 */
@RestController
@RequestMapping("/task/task")
public class TaskController extends BaseController
{
    @Autowired
    private ITaskService taskService;





    /**
     * 查询任务列表--待完成
     */
    @PreAuthorize("@ss.hasPermi('task:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(Task task)
    {
        startPage();
        List<Task> list = taskService.selectTaskList(task);
        return getDataTable(list);
    }

    /**
     * 导出任务列表
     */
    @PreAuthorize("@ss.hasPermi('task:task:export')")
    @Log(title = "任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Task task)
    {
        List<Task> list = taskService.selectTaskList(task);
        ExcelUtil<Task> util = new ExcelUtil<Task>(Task.class);
        util.exportExcel(response, list, "任务数据");
    }

    /**
     * 获取任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('task:task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(taskService.selectTaskById(id));
    }

    /**
     * 新增任务
     */
    @PreAuthorize("@ss.hasPermi('task:task:add')")
    @Log(title = "任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Task task)
    {
        return toAjax(taskService.insertTask(task));
    }

    /**
     * 修改任务
     */
    @PreAuthorize("@ss.hasPermi('task:task:edit')")
    @Log(title = "任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Task task)
    {
        return toAjax(taskService.updateTask(task));
    }

    /**
     * 删除任务
     */
    @PreAuthorize("@ss.hasPermi('task:task:remove')")
    @Log(title = "任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(taskService.deleteTaskByIds(ids));
    }


    /**
     * 完成任务
     */
    @PreAuthorize("@ss.hasPermi('task:task:remove')")
    @Log(title = "任务", businessType = BusinessType.FINISH)
    @GetMapping("f/{id}")
    public AjaxResult finish(@PathVariable Long id)
    {
        return toAjax(taskService.finshTaskById(id));
    }

    /**
     * 取消完成任务
     */
    @PreAuthorize("@ss.hasPermi('task:task:remove')")
    @Log(title = "任务", businessType = BusinessType.FINISH)
    @GetMapping("uf/{id}")
    public AjaxResult unfinish(@PathVariable Long id)
    {
        return toAjax(taskService.unfinshTaskById(id));
    }
}

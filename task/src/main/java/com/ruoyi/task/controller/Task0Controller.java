package com.ruoyi.task.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.task.domain.Task;
import com.ruoyi.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 任务Controller0
 * 
 * @author yi
 * @date 2024-10-23
 */
@RestController
@RequestMapping("/task/taskAll")
public class Task0Controller extends BaseController
{
    @Autowired
    private ITaskService taskService;

    /**
     * 查询任务列表-- 总表
     */
    @PreAuthorize("@ss.hasPermi('task:task:list')")
    @GetMapping("/")
    public TableDataInfo list(Task task)
    {
        startPage();
        List<Task> list = taskService.selectAllTaskList(task);
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
        List<Task> list = taskService.selectAllTaskList(task);
        ExcelUtil<Task> util = new ExcelUtil<Task>(Task.class);
        util.exportExcel(response, list, "任务数据");
    }


}

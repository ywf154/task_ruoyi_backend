package com.ruoyi.task.service;

import java.util.List;
import com.ruoyi.task.domain.Plate;

/**
 * 任务板块Service接口
 * 
 * @author yi
 * @date 2024-10-23
 */
public interface IPlateService 
{
    /**
     * 查询任务板块
     * 
     * @param id 任务板块主键
     * @return 任务板块
     */
    public Plate selectPlateById(Long id);

    /**
     * 查询任务板块列表
     * 
     * @param plate 任务板块
     * @return 任务板块集合
     */
    public List<Plate> selectPlateList(Plate plate);

    /**
     * 新增任务板块
     * 
     * @param plate 任务板块
     * @return 结果
     */
    public int insertPlate(Plate plate);

    /**
     * 修改任务板块
     * 
     * @param plate 任务板块
     * @return 结果
     */
    public int updatePlate(Plate plate);

    /**
     * 批量删除任务板块
     * 
     * @param ids 需要删除的任务板块主键集合
     * @return 结果
     */
    public int deletePlateByIds(Long[] ids);

    /**
     * 删除任务板块信息
     * 
     * @param id 任务板块主键
     * @return 结果
     */
    public int deletePlateById(Long id);
}

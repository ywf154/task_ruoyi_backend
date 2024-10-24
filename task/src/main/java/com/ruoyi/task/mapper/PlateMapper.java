package com.ruoyi.task.mapper;

import java.util.List;
import com.ruoyi.task.domain.Plate;
import com.ruoyi.task.domain.Type;

/**
 * 任务板块Mapper接口
 * 
 * @author yi
 * @date 2024-10-23
 */
public interface PlateMapper 
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
     * 删除任务板块
     * 
     * @param id 任务板块主键
     * @return 结果
     */
    public int deletePlateById(Long id);

    /**
     * 批量删除任务板块
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlateByIds(Long[] ids);

    /**
     * 批量删除任务类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTypeByPlateIds(Long[] ids);
    
    /**
     * 批量新增任务类型
     * 
     * @param typeList 任务类型列表
     * @return 结果
     */
    public int batchType(List<Type> typeList);
    

    /**
     * 通过任务板块主键删除任务类型信息
     * 
     * @param id 任务板块ID
     * @return 结果
     */
    public int deleteTypeByPlateId(Long id);
}

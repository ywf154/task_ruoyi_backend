package com.ruoyi.task.service;

import java.util.List;
import com.ruoyi.task.domain.Type;

/**
 * 任务类型Service接口
 * 
 * @author yi
 * @date 2024-10-23
 */
public interface ITypeService 
{
    /**
     * 查询任务类型
     * 
     * @param id 任务类型主键
     * @return 任务类型
     */
    public Type selectTypeById(Long id);

    /**
     * 查询任务类型列表
     * 
     * @param type 任务类型
     * @return 任务类型集合
     */
    public List<Type> selectTypeList(Type type);

    /**
     * 新增任务类型
     * 
     * @param type 任务类型
     * @return 结果
     */
    public int insertType(Type type);

    /**
     * 修改任务类型
     * 
     * @param type 任务类型
     * @return 结果
     */
    public int updateType(Type type);

    /**
     * 批量删除任务类型
     * 
     * @param ids 需要删除的任务类型主键集合
     * @return 结果
     */
    public int deleteTypeByIds(Long[] ids);

    /**
     * 删除任务类型信息
     * 
     * @param id 任务类型主键
     * @return 结果
     */
    public int deleteTypeById(Long id);
}

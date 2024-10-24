package com.ruoyi.task.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.task.mapper.TypeMapper;
import com.ruoyi.task.domain.Type;
import com.ruoyi.task.service.ITypeService;

/**
 * 任务类型Service业务层处理
 * 
 * @author yi
 * @date 2024-10-23
 */
@Service
public class TypeServiceImpl implements ITypeService 
{
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询任务类型
     * 
     * @param id 任务类型主键
     * @return 任务类型
     */
    @Override
    public Type selectTypeById(Long id)
    {
        return typeMapper.selectTypeById(id);
    }

    /**
     * 查询任务类型列表
     * 
     * @param type 任务类型
     * @return 任务类型
     */
    @Override
    public List<Type> selectTypeList(Type type)
    {
        return typeMapper.selectTypeList(type);
    }

    /**
     * 新增任务类型
     * 
     * @param type 任务类型
     * @return 结果
     */
    @Override
    public int insertType(Type type)
    {
        return typeMapper.insertType(type);
    }

    /**
     * 修改任务类型
     * 
     * @param type 任务类型
     * @return 结果
     */
    @Override
    public int updateType(Type type)
    {
        return typeMapper.updateType(type);
    }

    /**
     * 批量删除任务类型
     * 
     * @param ids 需要删除的任务类型主键
     * @return 结果
     */
    @Override
    public int deleteTypeByIds(Long[] ids)
    {
        return typeMapper.deleteTypeByIds(ids);
    }

    /**
     * 删除任务类型信息
     * 
     * @param id 任务类型主键
     * @return 结果
     */
    @Override
    public int deleteTypeById(Long id)
    {
        return typeMapper.deleteTypeById(id);
    }
}

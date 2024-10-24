package com.ruoyi.task.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.task.domain.Type;
import com.ruoyi.task.mapper.PlateMapper;
import com.ruoyi.task.domain.Plate;
import com.ruoyi.task.service.IPlateService;

/**
 * 任务板块Service业务层处理
 * 
 * @author yi
 * @date 2024-10-23
 */
@Service
public class PlateServiceImpl implements IPlateService 
{
    @Autowired
    private PlateMapper plateMapper;

    /**
     * 查询任务板块
     * 
     * @param id 任务板块主键
     * @return 任务板块
     */
    @Override
    public Plate selectPlateById(Long id)
    {
        return plateMapper.selectPlateById(id);
    }

    /**
     * 查询任务板块列表
     * 
     * @param plate 任务板块
     * @return 任务板块
     */
    @Override
    public List<Plate> selectPlateList(Plate plate)
    {
        return plateMapper.selectPlateList(plate);
    }

    /**
     * 新增任务板块
     * 
     * @param plate 任务板块
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPlate(Plate plate)
    {
        int rows = plateMapper.insertPlate(plate);
        insertType(plate);
        return rows;
    }

    /**
     * 修改任务板块
     * 
     * @param plate 任务板块
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePlate(Plate plate)
    {
        plateMapper.deleteTypeByPlateId(plate.getId());
        insertType(plate);
        return plateMapper.updatePlate(plate);
    }

    /**
     * 批量删除任务板块
     * 
     * @param ids 需要删除的任务板块主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePlateByIds(Long[] ids)
    {
        plateMapper.deleteTypeByPlateIds(ids);
        return plateMapper.deletePlateByIds(ids);
    }

    /**
     * 删除任务板块信息
     * 
     * @param id 任务板块主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePlateById(Long id)
    {
        plateMapper.deleteTypeByPlateId(id);
        return plateMapper.deletePlateById(id);
    }

    /**
     * 新增任务类型信息
     * 
     * @param plate 任务板块对象
     */
    public void insertType(Plate plate)
    {
        List<Type> typeList = plate.getTypeList();
        Long id = plate.getId();
        if (StringUtils.isNotNull(typeList))
        {
            List<Type> list = new ArrayList<Type>();
            for (Type type : typeList)
            {
                type.setPlateId(id);
                list.add(type);
            }
            if (list.size() > 0)
            {
                plateMapper.batchType(list);
            }
        }
    }
}

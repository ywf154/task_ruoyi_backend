package com.ruoyi.task.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务板块对象 plate
 * 
 * @author yi
 * @date 2024-10-23
 */
public class Plate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 板块ID */
    private Long id;

    /** 板块名 */
    @Excel(name = "板块名")
    private String name;

    /** 责任人 */
    @Excel(name = "责任人")
    private String dutyuser;

    /** 任务类型信息 */
    private List<Type> typeList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDutyuser(String dutyuser) 
    {
        this.dutyuser = dutyuser;
    }

    public String getDutyuser() 
    {
        return dutyuser;
    }

    public List<Type> getTypeList()
    {
        return typeList;
    }

    public void setTypeList(List<Type> typeList)
    {
        this.typeList = typeList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dutyuser", getDutyuser())
            .append("typeList", getTypeList())
            .toString();
    }
}

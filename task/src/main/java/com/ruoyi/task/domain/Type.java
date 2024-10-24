package com.ruoyi.task.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务类型对象 type
 * 
 * @author yi
 * @date 2024-10-23
 */
public class Type extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Primary Key */
    private Long id;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String name;

    /** 板块id */
    @Excel(name = "板块id")
    private Long plateId;

    /** 执行人 */
    @Excel(name = "执行人")
    private String douser;

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
    public void setPlateId(Long plateId) 
    {
        this.plateId = plateId;
    }

    public Long getPlateId() 
    {
        return plateId;
    }
    public void setDouser(String douser) 
    {
        this.douser = douser;
    }

    public String getDouser() 
    {
        return douser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("plateId", getPlateId())
            .append("douser", getDouser())
            .toString();
    }
}

package com.ruoyi.task.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务对象 task
 * 
 * @author yi
 * @date 2024-10-23
 */
public class Task extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long id;

    /** 任务名 */
    @Excel(name = "任务名")
    private String name;

    /** 接收通知 */
    @Excel(name = "接收通知")
    private String wxNoticeFrom;

    /** 交接人 */
    @Excel(name = "交接人")
    private String toWho;

    /** 发出通知 */
    @Excel(name = "发出通知")
    private String wxNoticeTo;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm")
    private Date endTime;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 完成时间 */
    private Date finishTime;

    /** 添加时间 */
    private Date addTime;

    /** 种类ID */
    @Excel(name = "种类ID")
    private Long typeId;

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
    public void setWxNoticeFrom(String wxNoticeFrom) 
    {
        this.wxNoticeFrom = wxNoticeFrom;
    }

    public String getWxNoticeFrom() 
    {
        return wxNoticeFrom;
    }
    public void setToWho(String toWho) 
    {
        this.toWho = toWho;
    }

    public String getToWho() 
    {
        return toWho;
    }
    public void setWxNoticeTo(String wxNoticeTo) 
    {
        this.wxNoticeTo = wxNoticeTo;
    }

    public String getWxNoticeTo() 
    {
        return wxNoticeTo;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("wxNoticeFrom", getWxNoticeFrom())
            .append("toWho", getToWho())
            .append("wxNoticeTo", getWxNoticeTo())
            .append("endTime", getEndTime())
            .append("status", getStatus())
            .append("finishTime", getFinishTime())
            .append("addTime", getAddTime())
            .append("typeId", getTypeId())
            .toString();
    }
}

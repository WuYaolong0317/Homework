package com.ruoyi.safepoint.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 安全项点记录对象 sp_safepoint
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
public class SpSafepoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Integer safepointId;

    /** 风险编码 */
    @Excel(name = "风险编码")
    private String safepointName;

    /** 部门 */
    @Excel(name = "部门")
    private String safepointDepartment;

    /** 类别 */
    @Excel(name = "类别")
    private String safepointClassification;

    /** 项目 */
    @Excel(name = "项目")
    private String safepointProject;

    /** 项点 */
    @Excel(name = "项点")
    private String safepointProjectpoint;

    /** 风险等级
 */
    @Excel(name = "风险等级 ")
    private Long safepointRisklevel;

    /** 危害程度 */
    @Excel(name = "危害程度")
    private Long safepointDangerlevel;

    public void setSafepointId(Integer safepointId) 
    {
        this.safepointId = safepointId;
    }

    public Integer getSafepointId() 
    {
        return safepointId;
    }
    public void setSafepointName(String safepointName) 
    {
        this.safepointName = safepointName;
    }

    public String getSafepointName() 
    {
        return safepointName;
    }
    public void setSafepointDepartment(String safepointDepartment) 
    {
        this.safepointDepartment = safepointDepartment;
    }

    public String getSafepointDepartment() 
    {
        return safepointDepartment;
    }
    public void setSafepointClassification(String safepointClassification) 
    {
        this.safepointClassification = safepointClassification;
    }

    public String getSafepointClassification() 
    {
        return safepointClassification;
    }
    public void setSafepointProject(String safepointProject) 
    {
        this.safepointProject = safepointProject;
    }

    public String getSafepointProject() 
    {
        return safepointProject;
    }
    public void setSafepointProjectpoint(String safepointProjectpoint) 
    {
        this.safepointProjectpoint = safepointProjectpoint;
    }

    public String getSafepointProjectpoint() 
    {
        return safepointProjectpoint;
    }
    public void setSafepointRisklevel(Long safepointRisklevel) 
    {
        this.safepointRisklevel = safepointRisklevel;
    }

    public Long getSafepointRisklevel() 
    {
        return safepointRisklevel;
    }
    public void setSafepointDangerlevel(Long safepointDangerlevel) 
    {
        this.safepointDangerlevel = safepointDangerlevel;
    }

    public Long getSafepointDangerlevel() 
    {
        return safepointDangerlevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("safepointId", getSafepointId())
            .append("safepointName", getSafepointName())
            .append("safepointDepartment", getSafepointDepartment())
            .append("safepointClassification", getSafepointClassification())
            .append("safepointProject", getSafepointProject())
            .append("safepointProjectpoint", getSafepointProjectpoint())
            .append("safepointRisklevel", getSafepointRisklevel())
            .append("safepointDangerlevel", getSafepointDangerlevel())
            .toString();
    }
}

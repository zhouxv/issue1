package com.issue1.demo.utilEntity;

import com.issue1.demo.entity.Issue2ResultDetail;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
@Note：

@User：NineSun
@Time:2021/1/28   23:10
*/
@Data
public class Issue2ResultUtil {
    /**
     服务ID-测评ID，课题一、课题五使用
     */
    @Valid
    @NotBlank(message = "serviceID_TestID字段不能为空")
    public String serviceID_TestID;

    /**
     参评业务名称
     */
    @Valid
    @NotBlank(message = "business_name字段不能为空")
    public String business_name;

    /**
     参评企业名称
     */
    @Valid
    @NotBlank(message = "company_name字段不能为空")
    public String company_name;

    /**
     参评业务介绍
     */
    @Valid
    @NotBlank(message = "business_introduce字段不能为空")
    public String business_introduce;

    /**
     测评人、测评机构
     */
    @Valid
    @NotBlank(message = "evaluation字段不能为空")
    public String evaluator;

    /**
     测评时间
     */
    @Valid
    @NotBlank(message = "evaluation_time字段不能为空")
    public String evaluation_time;

    /**
     测评地点
     */
    @Valid
    @NotBlank(message = "evaluation_addr字段不能为空")
    public String evaluation_addr;

    /**
     服务类别，课题一使用
     */
    @Valid
    @NotBlank(message = "服务类型不能为空")
    public String serviceType;

    /**
     等级
     */
    @Valid
    @NotNull(message = "level字段不能为null")
    public Integer level;

    /**
     测评结果
     */
    @Valid
    @NotNull(message = "evaluation_results不能为空")
    public List<Issue2ResultDetail> evaluation_results;
}

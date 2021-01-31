package com.issue1.demo.utilEntity.issue2ResultUtil;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/*
@Note：

@User：NineSun
@Time:2021/1/28   23:10
*/
@Data
@Valid
public class Issue2ResultUtil {
    /**
     服务ID-测评ID，课题一、课题五使用
     */
    @NotBlank(message = "serviceID_TestID字段不能为空")
    @Pattern(message = "serviceID_TestID字段格式为 整数1_整数2", regexp = "\\d+_\\d+")
    public String serviceID_TestID;

    /**
     参评业务名称
     */
    @NotBlank(message = "business_name字段不能为空")
    public String business_name;

    /**
     参评企业名称
     */
    @NotBlank(message = "company_name字段不能为空")
    public String company_name;

    /**
     参评业务介绍
     */
    @NotBlank(message = "business_introduce字段不能为空")
    public String business_introduce;

    /**
     测评人、测评机构
     */
    @NotBlank(message = "evaluation字段不能为空")
    public String evaluator;

    /**
     测评时间
     */
    @NotBlank(message = "evaluation_time字段不能为空")
    public String evaluation_time;

    /**
     测评地点
     */
    @NotBlank(message = "evaluation_addr字段不能为空")
    public String evaluation_addr;

    /**
     服务类别，课题一使用
     */
    @NotBlank(message = "服务类型不能为空")
    @Pattern(message = "服务类型必须为规定的九个类别之一", regexp = "数据服务|计算服务|网络服务|社交通讯服务|信息检索服务|信息管理服务|交易支付服务|多媒体服务|信息发布订阅服务")
    public String serviceType;

    /**
     等级
     */
    @NotNull(message = "level字段不能为null")
    @Min(message = "level字段的值应在1-4之间", value = 1)
    @Max(message = "level字段的值应在1-4之间", value = 4)
    public Integer level;

    /**
     * 测评结果
     */
    @Valid
    @NotNull(message = "evaluation_results不能为空")
    public List<Issue2ResultDetailUtil> evaluation_results;
}

package com.issue1.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@TableName("issue2_result")
public class Issue2Result {
    @TableId(value = "issue2ResultId", type = IdType.AUTO)
    private Integer issue2resultid;

    /**
     服务ID-测评ID，课题一、课题五使用
     */
    @TableField("serviceIdTestId")
    @Valid
    @NotBlank(message = "serviceID_TestID字段不能为空")
    private String serviceIDtestID;

    /**
     * 参评业务名称
     */
    @TableField("businessName")
    @Valid
    @NotBlank(message = "business_name字段不能为空")
    private String businessName;

    /**
     * 参评企业名称
     */
    @TableField("companyName")
    @Valid
    @NotBlank(message = "company_name字段不能为空")
    private String companyName;

    /**
     * 参评业务介绍
     */
    @TableField("businessIntroduce")
    @Valid
    @NotBlank(message = "business_introduce字段不能为空")
    private String businessIntroduce;

    /**
     * 测评人、测评机构
     */
    @TableField("evaluator")
    @Valid
    @NotBlank(message = "evaluation字段不能为空")
    private String evaluator;

    /**
     * 测评时间
     */
    @TableField("evaluationTime")
    @Valid
    @NotBlank(message = "evaluation_time字段不能为空")
    private String evaluationTime;

    /**
     * 测评地点
     */
    @TableField("evaluationAddr")
    @Valid
    @NotBlank(message = "evaluation_addr字段不能为空")
    private String evaluationAddr;

    /**
     * 服务类别，课题一使用
     */
    @TableField("serviceType")
    @Valid
    @NotBlank(message = "服务类型不能为空")
    private String serviceType;

    /**
     * 等级
     */
    @TableField("level")
    @Valid
    @NotNull(message = "level字段不能为null")
    private Integer level;

    /**
     测评结果
     */
    @Valid
    @NotNull(message = "evaluation_results不能为空")
    @TableField(exist = false)
    private List<Issue2ResultDetail> evaluation_results;


//    public Issue2Result(Issue2ResultUtil issue2ResultUtil) {
//        this.issue2resultid = issue2ResultUtil.issue2resultid;
//        this.serviceIDtestID = issue2ResultUtil.serviceID_TestID;
//        this.businessName = issue2ResultUtil.business_name;
//        this.companyName = issue2ResultUtil.company_name;
//        this.businessIntroduce = issue2ResultUtil.business_introduce;
//        this.evaluator = issue2ResultUtil.evaluator;
//        this.evaluationTime = issue2ResultUtil.evaluation_time;
//        this.evaluationAddr = issue2ResultUtil.evaluation_addr;
//        this.serviceType = issue2ResultUtil.serviceType;
//        this.level = issue2ResultUtil.level;
//        this.evaluation_results = issue2ResultUtil.evaluation_results;
//    }
}

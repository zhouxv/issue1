package com.issue1.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
    private String serviceIDtestID;

    /**
     * 参评业务名称
     */
    @TableField("businessName")
    private String businessName;

    /**
     * 参评企业名称
     */
    @TableField("companyName")
    private String companyName;

    /**
     * 参评业务介绍
     */
    @TableField("businessIntroduce")
    private String businessIntroduce;

    /**
     * 测评人、测评机构
     */
    @TableField("evaluator")
    private String evaluator;

    /**
     * 测评时间
     */
    @TableField("evaluationTime")
    private String evaluationTime;

    /**
     * 测评地点
     */
    @TableField("evaluationAddr")
    private String evaluationAddr;

    /**
     * 服务类别，课题一使用
     */
    @TableField("serviceType")
    private String serviceType;

    /**
     * 等级
     */
    @TableField("level")
    private Integer level;

    /**
     测评结果
     */
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

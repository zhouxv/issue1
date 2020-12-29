package com.issue1.demo.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author zhouxv
 * @date 2020-12-21 14:47:28
 */
@Data
@TableName("group_level")
public class GroupLevel {

    /**
     * 安全族等级Id
     */
    @TableId(value = "groupLevelId", type = IdType.AUTO)
    private Integer grouplevelid;

    /**
     * 对应的服务
     */
    @TableField("serviceId")
    private Integer serviceid;

    /**
     * 边界防护,1
     */
    @TableField("perimeterSecurity")
    private String perimetersecurity;

    /**
     * 访问控制,2
     */
    @TableField("accessControl")
    private String accesscontrol;

    /**
     * 身份鉴别,3
     */
    @TableField("identityAuthentication")
    private String identityauthentication;

    /**
     * 密码支持,4
     */
    @TableField("cryptographicSupport")
    private String cryptographicsupport;

    /**
     * 入侵防范,5
     */
    @TableField("intrusionPrevention")
    private String intrusionprevention;

    /**
     * 监控与检测,6
     */
    @TableField("monitorDetect")
    private String monitordetect;

    /**
     * 恶意代码防范,7
     */
    @TableField("maliciousCodeResistance")
    private String maliciouscoderesistance;

    /**
     * 数据保密性,8
     */
    @TableField("dataConfidentiality")
    private String dataconfidentiality;

    /**
     * 数据完整性,9
     */
    @TableField("dataIntegrity")
    private String dataintegrity;

    /**
     * 数据和应用可用性,10
     */
    @TableField("DataAvailability")
    private String dataavailability;

    /**
     * 数据销毁,11
     */
    @TableField("dataDestruction")
    private String datadestruction;

    /**
     * 数据备份恢复,12
     */
    @TableField("backupRecovery")
    private String backuprecovery;

    /**
     * 个人数据处理,13
     */
    @TableField("dataPrivacy")
    private String dataprivacy;

    /**
     * 安全审计与验证,14
     */
    @TableField("securityValidation")
    private String securityvalidation;

    /**
     * 机构配置管理,15
     */
    @TableField("organizationalManagement")
    private String organizationalmanagement;

    /**
     * 剩余信息保护,16
     */
    @TableField("redundancyCleanup")
    private String redundancycleanup;

    /**
     * 安全策略,17
     */
    @TableField("securityPolicy")
    private String securitypolicy;

    /**
     * 事件预警和处置,18
     */
    @TableField("eventAlert")
    private String eventalert;

    /**
     * 管理制度,19
     */
    @TableField("systemManagement")
    private String systemmanagement;

    /**
     * 安全日志,20
     */
    @TableField("securityLog")
    private String securitylog;

    /**
     * 流程管理,21
     */
    @TableField("processManagement")
    private String processmanagement;

    /**
     * 服务协议,22
     */
    @TableField("serviceAgreement")
    private String serviceagreement;

    /**
     * 电子合同,23
     */
    @TableField("electronicContract")
    private String electroniccontract;

}

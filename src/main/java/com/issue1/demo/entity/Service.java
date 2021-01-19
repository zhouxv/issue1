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
 */
@Data
@TableName("service")
public class Service {

    /**
     * 服务Id
     */
    @TableId(value = "serviceId", type = IdType.AUTO)
    private Integer serviceid;

    /**
     * 服务名称
     */
    @TableField("serviceName")
    private String servicename;

    /**
     * 删除状态
     */
    @TableField("deleteState")
    private Integer deletestate;

    /**
     * 测评状态
     */
    @TableField("state")
    private Integer state;

    /**
     * 服务的参评公司
     */
    @TableField("serviceCompany")
    private String servicecompany;

    /**
     * 服务类型,九个类别之一
     */
    @TableField("serviceType")
    private String servicetype;

    /**
     * 测试机构
     */
    @TableField("testOrganization")
    private String testorganization;

    /**
     * 服务的综合安全等级
     */
    @TableField("serviceLevel")
    private String servicelevel;
}

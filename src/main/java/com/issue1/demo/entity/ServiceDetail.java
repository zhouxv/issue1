package com.issue1.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *  Entity
 *
 * @author zhouxv
 */
@Data
@TableName("service_detail")
public class ServiceDetail {

    /**
     * 
     */
    @TableId(value = "serviceDetailId", type = IdType.AUTO)
    private Integer servicedetailid;

    /**
     * 服务详情的Id
     */
    @Valid
    @TableField("serviceId")
    @NotNull(message = "serviceid不能为null")
    private Integer serviceid;

    /**
     * 删除状态
     */
    @TableField("deleteState")
    private Integer deletestate;

    /**
     * 公司名称
     */
    @TableField("companyName")
    private String companyname;

    /**
     * 法人信息
     */
    @TableField("legalPerson")
    private String legalperson;

    /**
     * 社会统一信用代码
     */
    @TableField("SUIC")
    private String suic;

    /**
     * 注册时间
     */
    @TableField("regDate")
    private String regdate;

    /**
     * 注册资本
     */
    @TableField("regCapital")
    private String regcapital;

    /**
     * 注册地址
     */
    @TableField("regAddress")
    private String regaddress;

    /**
     * 公司类型
     */
    @TableField("companyType")
    private String companytype;

    /**
     * 经营范围
     */
    @TableField("businessScope")
    private String businessscope;

    /**
     * 营业执照期限
     */
    @TableField("term")
    private String term;

    /**
     * 平台登陆邮箱
     */
    @TableField("signupEmail")
    private String signupemail;

    /**
     * 平台登陆密码
     */
    @TableField("signupPass")
    private String signuppass;

    /**
     * 联系人
     */
    @TableField("linkMan")
    private String linkman;

    /**
     * 联系人电话
     */
    @TableField("linkManTel")
    private String linkmantel;

    /**
     * 服务名称
     */
    @TableField("serviceName")
    private String servicename;

    /**
     * 服务类型
     */
    @TableField("serviceType")
    private String servicetype;

    /**
     * 服务对象
     */
    @TableField("serviceObject")
    private String serviceobject;

    /**
     * 服务地点
     */
    @TableField("serviceLocation")
    private String servicelocation;

    /**
     * 服务期限
     */
    @TableField("serviceTerm")
    private String serviceterm;

    /**
     * 服务链接
     */
    @TableField("serviceUrl")
    private String serviceurl;

    /**
     * 服务简介
     */
    @TableField("serviceIntro")
    private String serviceintro;

    /**
     * 服务ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 服务端口
     */
    @TableField("port")
    private String port;

    /**
     * 账号
     */
    @TableField("username")
    private String username;

    /**
     * 口令
     */
    @TableField("password")
    private String password;

    /**
     * 网络连接协议
     */
    @TableField("protocol")
    private String protocol;

}

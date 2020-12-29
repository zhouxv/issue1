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
@TableName("sag_level")
public class SagLevel {

    /**
     * 
     */
    @TableId(value = "sagLevelId", type = IdType.AUTO)
    private Integer saglevelid;

    /**
     * 
     */
    @TableField("serviceId")
    private Integer serviceid;

    /**
     * 
     */
    @TableField("sResult")
    private String sresult;

    /**
     * 
     */
    @TableField("aResult")
    private String aresult;

    /**
     * 
     */
    @TableField("gResult")
    private String gresult;

    /**
     * 
     */
    @TableField("level")
    private String level;

}

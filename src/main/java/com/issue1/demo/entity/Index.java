package com.issue1.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  Entity
 *
 * @author zhouxv
 * @date 2020-12-21 14:47:28
 */
@Data
@TableName("index_item")
public class Index {

    /**
     * 安全族等级Id
     */
    @TableId(value = "indexId", type = IdType.AUTO)
    private Integer indexid;

    /**
     * 安全族
     */
    @TableField("securityGroup")
    private String securitygroup;

    /**
     * 指标名称
     */
    @TableField("indexName")
    private String indexname;

    /**
     * 指标释义
     */
    @TableField("indexDescription")
    private String indexdescription;


}

package com.issue1.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@TableName("issue2_result_detail")
public class Issue2ResultDetail {
    @TableId(value = "issue2ResultDetailId", type = IdType.AUTO)
    private Integer issue2resultdetailid;

    @TableField("issue2ResultId")
    private Integer issue2resultid;

    @TableField("secureGroup")
    @Valid
    @NotBlank(message = "evaluation_results中的secure_group字段不能为空")
    private String secure_group;

    @TableField("indexItem")
    @Valid
    @NotBlank(message = "evaluation_results中的index_item字段不能为空")
    private String index_item;

    @TableField("_index")
    @Valid
    @NotNull(message = "evaluation_results中的index字段不能为null")
    private Integer index;

    @TableField("level")
    @Valid
    @NotBlank(message = "evaluation_results中的level字段不能为空")
    private String level;

    @TableField("conf")
    @Valid
    @NotBlank(message = "evaluation_results中的conf字段不能为空")
    private String conf;
}

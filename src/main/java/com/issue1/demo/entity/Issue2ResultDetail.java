package com.issue1.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("issue2_result_detail")
public class Issue2ResultDetail {
    @TableId(value = "issue2ResultDetailId", type = IdType.AUTO)
    private Integer issue2resultdetailid;

    @TableField("issue2ResultId")
    private Integer issue2resultid;

    @TableField("serviceIdTestId")
    private String serviceIDtestID;

    @TableField("secureGroup")
    private String secure_group;

    @TableField("indexItem")
    private String index_item;

    @TableField("_index")
    private Integer index;

    @TableField("level")
    private Integer grade;

    @TableField("conf")
    private String conf;
}

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
 * 2020-12-21 14:47:28
 */
@Data
public class GroupLevelDto {
    private String grouplevelname;
    private String grouplevelindex;
    private String score;

    public GroupLevelDto(String grouplevelname, String grouplevelindex, String score) {
        this.grouplevelname = grouplevelname;
        this.grouplevelindex = grouplevelindex;
        this.score = score;
    }
}

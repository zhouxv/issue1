package com.issue1.demo.entity;

import lombok.Data;

@Data
public class SagLevelDto {
    private String saglevelname;
    private String sagdescription;
    private String score;


    public SagLevelDto() {
    }

    public SagLevelDto(String saglevelname, String sagdescription, String score) {
        this.saglevelname = saglevelname;
        this.sagdescription = sagdescription;
        this.score = score;
    }
}

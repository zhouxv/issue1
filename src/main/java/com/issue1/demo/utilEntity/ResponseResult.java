package com.issue1.demo.utilEntity;

import com.alibaba.fastjson.annotation.JSONField;


public class ResponseResult {
    @JSONField(name = "data")
    private String data;
    @JSONField(name = "data")
    private String msg;
    @JSONField(name = "data")
    private String code;

    public ResponseResult(String data, String msg, String code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public ResponseResult() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

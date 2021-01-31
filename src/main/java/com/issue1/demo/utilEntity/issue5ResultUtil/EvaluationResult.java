package com.issue1.demo.utilEntity.issue5ResultUtil;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:24
*/
public class EvaluationResult {
    private String index;
    private String conf;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public EvaluationResult(String index, String conf) {
        this.index = index;
        this.conf = conf;
    }

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }
}

package com.issue1.demo.utilEntity.issue5ResultUtil;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:24
*/
public class EvalutionResult {
    private String index;
    private String vonf;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getVonf() {
        return vonf;
    }

    public void setVonf(String vonf) {
        this.vonf = vonf;
    }

    public EvalutionResult(String index, String vonf) {
        this.index = index;
        this.vonf = vonf;
    }
}

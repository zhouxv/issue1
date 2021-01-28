package com.issue1.demo.utilEntity;

import java.util.List;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:20
*/
public class EvalutionResults {
    private List<EvalutionResult> level_1;
    private List<EvalutionResult> level_2;
    private List<EvalutionResult> level_3;
    private List<EvalutionResult> level_4;

    public List<EvalutionResult> getLevel_1() {
        return level_1;
    }

    public void setLevel_1(List<EvalutionResult> level_1) {
        this.level_1 = level_1;
    }

    public List<EvalutionResult> getLevel_2() {
        return level_2;
    }

    public void setLevel_2(List<EvalutionResult> level_2) {
        this.level_2 = level_2;
    }

    public List<EvalutionResult> getLevel_3() {
        return level_3;
    }

    public void setLevel_3(List<EvalutionResult> level_3) {
        this.level_3 = level_3;
    }

    public List<EvalutionResult> getLevel_4() {
        return level_4;
    }

    public void setLevel_4(List<EvalutionResult> level_4) {
        this.level_4 = level_4;
    }
}

package com.issue1.demo.utilEntity.issue5ResultUtil;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:28
*/
public class Issue1SagLevel {
    private String level;
    private Issue1SagLevelDetail sLevel;
    private Issue1SagLevelDetail aLevel;
    private Issue1SagLevelDetail gLevel;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Issue1SagLevelDetail getsLevel() {
        return sLevel;
    }

    public void setsLevel(Issue1SagLevelDetail sLevel) {
        this.sLevel = sLevel;
    }

    public Issue1SagLevelDetail getaLevel() {
        return aLevel;
    }

    public void setaLevel(Issue1SagLevelDetail aLevel) {
        this.aLevel = aLevel;
    }

    public Issue1SagLevelDetail getgLevel() {
        return gLevel;
    }

    public void setgLevel(Issue1SagLevelDetail gLevel) {
        this.gLevel = gLevel;
    }
}

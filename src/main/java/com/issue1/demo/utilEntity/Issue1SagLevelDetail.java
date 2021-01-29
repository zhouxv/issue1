package com.issue1.demo.utilEntity;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:28
*/
public class Issue1SagLevelDetail {
    private String value;
    private Score score;

    public Issue1SagLevelDetail(Double[] doubles) {
        this.value = doubles[4].intValue() + "";
        this.score = new Score(doubles[0].toString(), doubles[1].toString(), doubles[2].toString(), doubles[3].toString());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

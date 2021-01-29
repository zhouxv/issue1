package com.issue1.demo.utilEntity;

import java.util.List;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:14
*/
public class Issue5Result_1 {
    private Issue1TopLevel topLevel;
    private Issue1SagLevel sagLevel;
    private List<Issue1GroupLevel> groupLevel;

    public Issue1TopLevel getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(Issue1TopLevel topLevel) {
        this.topLevel = topLevel;
    }

    public Issue1SagLevel getSagLevel() {
        return sagLevel;
    }

    public void setSagLevel(Issue1SagLevel sagLevel) {
        this.sagLevel = sagLevel;
    }

    public List<Issue1GroupLevel> getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(List<Issue1GroupLevel> groupLevel) {
        this.groupLevel = groupLevel;
    }


}

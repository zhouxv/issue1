package com.issue1.demo.utilEntity.issue5ResultUtil;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:28
*/
public class Issue1TopLevel {
    private String value;

    public String getValue() {
        return value;
    }

    public Issue1TopLevel(String value) {
        this.setValue(value);
    }

    public void setValue(String value) {
        switch (value) {
            case "基础定义级": {
                this.value = "1";
                break;
            }
            case "增强控制级": {
                this.value = "2";
                break;
            }
            case "持续优化级": {
                this.value = "3";
                break;
            }
            case "量化完善级": {
                this.value = "4";
                break;
            }
            default: {
                this.value = "-99";
            }
        }
    }
}

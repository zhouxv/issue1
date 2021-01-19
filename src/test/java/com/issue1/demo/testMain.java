package com.issue1.demo;

import com.issue1.demo.entity.TestResult;
import com.issue1.demo.util.CountIndexLevel;

import static com.issue1.demo.util.CountIndexLevel.indexLevel;
import static com.issue1.demo.util.CountSagLevel.countFinalLevel;

public class testMain {
    public static void main(String[] args) {
        TestResult a=new TestResult();
        a.setResult1("1,1,1,1,1,1,1,1");
        System.out.println(a.getResult1());
    }

}

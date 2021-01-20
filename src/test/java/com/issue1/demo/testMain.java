package com.issue1.demo;

import com.issue1.demo.entity.TestResult;
import com.issue1.demo.util.CountIndexLevel;

import java.text.DecimalFormat;

import static com.issue1.demo.util.CountIndexLevel.indexLevel;
import static com.issue1.demo.util.CountSagLevel.countFinalLevel;

public class testMain {
    public static void main(String[] args) {
        double d=6.667;
        DecimalFormat df = new DecimalFormat("#.00");
        df.format(d);
        System.out.println(df.format(d));
    }
}

package com.issue1.demo.util;

import com.issue1.demo.entity.TestResult;

import java.util.ArrayList;
import java.util.List;

/*
转换类，为了方便处理转换一些格式
*/
public class ConvertList {
    //把testResult的130个结果存储到到list中
    public static List<String> convertTestResult(TestResult testResult) {
        List<String> list = new ArrayList<>();
        list.add(testResult.getResult1());
        list.add(testResult.getResult2());
        list.add(testResult.getResult3());
        list.add(testResult.getResult4());
        list.add(testResult.getResult5());
        list.add(testResult.getResult6());
        list.add(testResult.getResult7());
        list.add(testResult.getResult8());
        list.add(testResult.getResult9());
        list.add(testResult.getResult10());
        list.add(testResult.getResult11());
        list.add(testResult.getResult12());
        list.add(testResult.getResult13());
        list.add(testResult.getResult14());
        list.add(testResult.getResult15());
        list.add(testResult.getResult16());
        list.add(testResult.getResult17());
        list.add(testResult.getResult18());
        list.add(testResult.getResult19());
        list.add(testResult.getResult20());
        list.add(testResult.getResult21());
        list.add(testResult.getResult22());
        list.add(testResult.getResult23());
        list.add(testResult.getResult24());
        list.add(testResult.getResult25());
        list.add(testResult.getResult26());
        list.add(testResult.getResult27());
        list.add(testResult.getResult28());
        list.add(testResult.getResult29());
        list.add(testResult.getResult30());
        list.add(testResult.getResult31());
        list.add(testResult.getResult32());
        list.add(testResult.getResult33());
        list.add(testResult.getResult34());
        list.add(testResult.getResult35());
        list.add(testResult.getResult36());
        list.add(testResult.getResult37());
        list.add(testResult.getResult38());
        list.add(testResult.getResult39());
        list.add(testResult.getResult40());
        list.add(testResult.getResult41());
        list.add(testResult.getResult42());
        list.add(testResult.getResult43());
        list.add(testResult.getResult44());
        list.add(testResult.getResult45());
        list.add(testResult.getResult46());
        list.add(testResult.getResult47());
        list.add(testResult.getResult48());
        list.add(testResult.getResult49());
        list.add(testResult.getResult50());
        list.add(testResult.getResult51());
        list.add(testResult.getResult52());
        list.add(testResult.getResult53());
        list.add(testResult.getResult54());
        list.add(testResult.getResult55());
        list.add(testResult.getResult56());
        list.add(testResult.getResult57());
        list.add(testResult.getResult58());
        list.add(testResult.getResult59());
        list.add(testResult.getResult60());
        list.add(testResult.getResult61());
        list.add(testResult.getResult62());
        list.add(testResult.getResult63());
        list.add(testResult.getResult64());
        list.add(testResult.getResult65());
        list.add(testResult.getResult66());
        list.add(testResult.getResult67());
        list.add(testResult.getResult68());
        list.add(testResult.getResult69());
        list.add(testResult.getResult70());
        list.add(testResult.getResult71());
        list.add(testResult.getResult72());
        list.add(testResult.getResult73());
        list.add(testResult.getResult74());
        list.add(testResult.getResult75());
        list.add(testResult.getResult76());
        list.add(testResult.getResult77());
        list.add(testResult.getResult78());
        list.add(testResult.getResult79());
        list.add(testResult.getResult80());
        list.add(testResult.getResult81());
        list.add(testResult.getResult82());
        list.add(testResult.getResult83());
        list.add(testResult.getResult84());
        list.add(testResult.getResult85());
        list.add(testResult.getResult86());
        list.add(testResult.getResult87());
        list.add(testResult.getResult88());
        list.add(testResult.getResult89());
        list.add(testResult.getResult90());
        list.add(testResult.getResult91());
        list.add(testResult.getResult92());
        list.add(testResult.getResult93());
        list.add(testResult.getResult94());
        list.add(testResult.getResult95());
        list.add(testResult.getResult96());
        list.add(testResult.getResult97());
        list.add(testResult.getResult98());
        list.add(testResult.getResult99());
        list.add(testResult.getResult100());
        list.add(testResult.getResult101());
        list.add(testResult.getResult102());
        list.add(testResult.getResult103());
        list.add(testResult.getResult104());
        list.add(testResult.getResult105());
        list.add(testResult.getResult106());
        list.add(testResult.getResult107());
        list.add(testResult.getResult108());
        list.add(testResult.getResult109());
        list.add(testResult.getResult110());
        list.add(testResult.getResult111());
        list.add(testResult.getResult112());
        list.add(testResult.getResult113());
        list.add(testResult.getResult114());
        list.add(testResult.getResult115());
        list.add(testResult.getResult116());
        list.add(testResult.getResult117());
        list.add(testResult.getResult118());
        list.add(testResult.getResult119());
        list.add(testResult.getResult120());
        list.add(testResult.getResult121());
        list.add(testResult.getResult122());
        list.add(testResult.getResult123());
        list.add(testResult.getResult124());
        list.add(testResult.getResult125());
        list.add(testResult.getResult126());
        list.add(testResult.getResult127());
        list.add(testResult.getResult128());
        list.add(testResult.getResult129());
        list.add(testResult.getResult130());
        return list;
    }

    // 把字符串字符转换为double[]
    public static Double[] stringToDoubleArray(String str){
        String[] strArray = str.split(",");
        Double[] doubleArray = new Double[strArray.length];
        System.out.println("字符串数组的长度为" + strArray.length);
        for (int i = 0; i < strArray.length; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }
        return doubleArray;
    }

    // 把字符串字符转换为List<double>
    public static List<Double> stringToDoubleList(String str){
        String[] strArray = str.split(",");
        List<Double> doubleList=new ArrayList<>();
        for (String s : strArray) {
            doubleList.add(Double.parseDouble(s));
        }
        return doubleList;
    }
}

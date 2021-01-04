package com.issue1.demo.util;

import com.issue1.demo.entity.GroupLevel;
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

    //把groupLevel的23个结果存储到到list中
    public static List<String> convertGroupLevel(GroupLevel groupLevel){
        List<String> list = new ArrayList<>();
        //1.边界防护
        list.add(groupLevel.getPerimetersecurity());
        //2.访问控制
        list.add(groupLevel.getAccesscontrol());
        //3.身份鉴别
        list.add(groupLevel.getIdentityauthentication());
        //4.密码支持
        list.add(groupLevel.getCryptographicsupport());
        //5.入侵防范
        list.add(groupLevel.getIntrusionprevention());
        //6.监控与检测
        list.add(groupLevel.getMonitordetect());
        //7.恶意代码防范
        list.add(groupLevel.getMaliciouscoderesistance());
        //8.数据保密性
        list.add(groupLevel.getDataconfidentiality());
        //9.数据完整性
        list.add(groupLevel.getDataintegrity());
        //10.数据和应用可用性
        list.add(groupLevel.getDataavailability());
        //11.数据销毁
        list.add(groupLevel.getDatadestruction());
        //12.数据备份恢复
        list.add(groupLevel.getBackuprecovery());
        //13.个人数据恢复
        list.add(groupLevel.getDataprivacy());
        //14.安全审计与验证
        list.add(groupLevel.getSecurityvalidation());
        //15.机构配置管理
        list.add(groupLevel.getOrganizationalmanagement());
        //16.剩余信息保护
        list.add(groupLevel.getRedundancycleanup());
        //17.安全策略
        list.add(groupLevel.getSecuritypolicy());
        //18.事件预警和处置
        list.add(groupLevel.getEventalert());
        //19.管理制度
        list.add(groupLevel.getSystemmanagement());
        //20.安全日志
        list.add(groupLevel.getSecuritylog());
        //21.流程管理
        list.add(groupLevel.getProcessmanagement());
        //22.服务协议
        list.add(groupLevel.getServiceagreement());
        //23.电子合同
        list.add(groupLevel.getElectroniccontract());
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

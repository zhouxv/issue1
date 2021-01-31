package com.issue1.demo.util.countLevel;

import com.issue1.demo.entity.TestResult;

import static com.issue1.demo.util.ConvertList.stringToDoubleArray;

/*
计算指标项等级
 */
public class CountIndexLevel {
    /**
     计算符合度是否达到要求

     @param x double 达到测评要求的指标条目数量
     @param y double 测评指标条目总数
     @return boolean
     */
    public static boolean conformity(double x, double y) {
        boolean bool = (x / y > 0.5);
//        System.out.println(x + "/" + y + ">0.5? " + bool);
        return bool;
    }

    /**
     计算某个指标的等级

     @param str String 字符串中四个等级的符合度，以逗号分隔，“1,1,1,1,1,1,1,1”，共包含八个数字，
     @return String
     */
    public static String indexLevel(String str,Integer index) {
        int indexLevel = 0;
        Double[] doubleArray = stringToDoubleArray(str);

        //输入格式的校验
        if (doubleArray.length != 8 && doubleArray.length != 9) {
            System.out.println("输入参数格式错误，字符中应包含8或9个数字，然而实际输入中数字数目为 " + doubleArray.length);
            return str;
        }

        StringBuffer stringBuffer = new StringBuffer();


        for (int i = 0; i < 4; i++) {
            stringBuffer.append(doubleArray[2 * i]).append(",").append(doubleArray[2 * i + 1]).append(",");
        }
        //计算指标等级
        for (int i = 0; i < 4; i++) {
            if (conformity(doubleArray[2 * i], doubleArray[2 * i + 1])) {
                indexLevel++;
                continue;
            }
            break;
        }
//        System.out.println("指标项 "+index+" 等级为：" + indexLevel);
//        System.out.println(stringBuffer.toString() + indexLevel);

        return stringBuffer.toString() + indexLevel;
    }

    //计算testResult所有的index等级
    public static void countTestResult(TestResult testResult) {
        testResult.setResult1(indexLevel(testResult.getResult1(),1));
        testResult.setResult2(indexLevel(testResult.getResult2(),2));
        testResult.setResult3(indexLevel(testResult.getResult3(),3));
        testResult.setResult4(indexLevel(testResult.getResult4(),4));
        testResult.setResult5(indexLevel(testResult.getResult5(),5));
        testResult.setResult6(indexLevel(testResult.getResult6(),6));
        testResult.setResult7(indexLevel(testResult.getResult7(),7));
        testResult.setResult8(indexLevel(testResult.getResult8(),8));
        testResult.setResult9(indexLevel(testResult.getResult9(),9));
        testResult.setResult10(indexLevel(testResult.getResult10(),10));
        testResult.setResult11(indexLevel(testResult.getResult11(),11));
        testResult.setResult12(indexLevel(testResult.getResult12(),12));
        testResult.setResult13(indexLevel(testResult.getResult13(),13));
        testResult.setResult14(indexLevel(testResult.getResult14(),14));
        testResult.setResult15(indexLevel(testResult.getResult15(),15));
        testResult.setResult16(indexLevel(testResult.getResult16(),16));
        testResult.setResult17(indexLevel(testResult.getResult17(),17));
        testResult.setResult18(indexLevel(testResult.getResult18(),18));
        testResult.setResult19(indexLevel(testResult.getResult19(),19));
        testResult.setResult20(indexLevel(testResult.getResult20(),20));
        testResult.setResult21(indexLevel(testResult.getResult21(),21));
        testResult.setResult22(indexLevel(testResult.getResult22(),22));
        testResult.setResult23(indexLevel(testResult.getResult23(),23));
        testResult.setResult24(indexLevel(testResult.getResult24(),24));
        testResult.setResult25(indexLevel(testResult.getResult25(),25));
        testResult.setResult26(indexLevel(testResult.getResult26(),26));
        testResult.setResult27(indexLevel(testResult.getResult27(),27));
        testResult.setResult28(indexLevel(testResult.getResult28(),28));
        testResult.setResult29(indexLevel(testResult.getResult29(),29));
        testResult.setResult30(indexLevel(testResult.getResult30(),30));
        testResult.setResult31(indexLevel(testResult.getResult31(),31));
        testResult.setResult32(indexLevel(testResult.getResult32(),32));
        testResult.setResult33(indexLevel(testResult.getResult33(),33));
        testResult.setResult34(indexLevel(testResult.getResult34(),34));
        testResult.setResult35(indexLevel(testResult.getResult35(),35));
        testResult.setResult36(indexLevel(testResult.getResult36(),36));
        testResult.setResult37(indexLevel(testResult.getResult37(),37));
        testResult.setResult38(indexLevel(testResult.getResult38(),38));
        testResult.setResult39(indexLevel(testResult.getResult39(),39));
        testResult.setResult40(indexLevel(testResult.getResult40(),40));
        testResult.setResult41(indexLevel(testResult.getResult41(),41));
        testResult.setResult42(indexLevel(testResult.getResult42(),42));
        testResult.setResult43(indexLevel(testResult.getResult43(),43));
        testResult.setResult44(indexLevel(testResult.getResult44(),44));
        testResult.setResult45(indexLevel(testResult.getResult45(),45));
        testResult.setResult46(indexLevel(testResult.getResult46(),46));
        testResult.setResult47(indexLevel(testResult.getResult47(),47));
        testResult.setResult48(indexLevel(testResult.getResult48(),48));
        testResult.setResult49(indexLevel(testResult.getResult49(),49));
        testResult.setResult50(indexLevel(testResult.getResult50(),50));
        testResult.setResult51(indexLevel(testResult.getResult51(),51));
        testResult.setResult52(indexLevel(testResult.getResult52(),52));
        testResult.setResult53(indexLevel(testResult.getResult53(),53));
        testResult.setResult54(indexLevel(testResult.getResult54(),54));
        testResult.setResult55(indexLevel(testResult.getResult55(),55));
        testResult.setResult56(indexLevel(testResult.getResult56(),56));
        testResult.setResult57(indexLevel(testResult.getResult57(),57));
        testResult.setResult58(indexLevel(testResult.getResult58(),58));
        testResult.setResult59(indexLevel(testResult.getResult59(),59));
        testResult.setResult60(indexLevel(testResult.getResult60(),60));
        testResult.setResult61(indexLevel(testResult.getResult61(),61));
        testResult.setResult62(indexLevel(testResult.getResult62(),62));
        testResult.setResult63(indexLevel(testResult.getResult63(),63));
        testResult.setResult64(indexLevel(testResult.getResult64(),64));
        testResult.setResult65(indexLevel(testResult.getResult65(),65));
        testResult.setResult66(indexLevel(testResult.getResult66(),66));
        testResult.setResult67(indexLevel(testResult.getResult67(),67));
        testResult.setResult68(indexLevel(testResult.getResult68(),68));
        testResult.setResult69(indexLevel(testResult.getResult69(),69));
        testResult.setResult70(indexLevel(testResult.getResult70(),70));
        testResult.setResult71(indexLevel(testResult.getResult71(),71));
        testResult.setResult72(indexLevel(testResult.getResult72(),72));
        testResult.setResult73(indexLevel(testResult.getResult73(),73));
        testResult.setResult74(indexLevel(testResult.getResult74(),74));
        testResult.setResult75(indexLevel(testResult.getResult75(),75));
        testResult.setResult76(indexLevel(testResult.getResult76(),76));
        testResult.setResult77(indexLevel(testResult.getResult77(),77));
        testResult.setResult78(indexLevel(testResult.getResult78(),78));
        testResult.setResult79(indexLevel(testResult.getResult79(),79));
        testResult.setResult80(indexLevel(testResult.getResult80(),80));
        testResult.setResult81(indexLevel(testResult.getResult81(),81));
        testResult.setResult82(indexLevel(testResult.getResult82(),82));
        testResult.setResult83(indexLevel(testResult.getResult83(),83));
        testResult.setResult84(indexLevel(testResult.getResult84(),84));
        testResult.setResult85(indexLevel(testResult.getResult85(),85));
        testResult.setResult86(indexLevel(testResult.getResult86(),86));
        testResult.setResult87(indexLevel(testResult.getResult87(),87));
        testResult.setResult88(indexLevel(testResult.getResult88(),88));
        testResult.setResult89(indexLevel(testResult.getResult89(),89));
        testResult.setResult90(indexLevel(testResult.getResult90(),90));
        testResult.setResult91(indexLevel(testResult.getResult91(),91));
        testResult.setResult92(indexLevel(testResult.getResult92(),92));
        testResult.setResult93(indexLevel(testResult.getResult93(),93));
        testResult.setResult94(indexLevel(testResult.getResult94(),94));
        testResult.setResult95(indexLevel(testResult.getResult95(),95));
        testResult.setResult96(indexLevel(testResult.getResult96(),96));
        testResult.setResult97(indexLevel(testResult.getResult97(),97));
        testResult.setResult98(indexLevel(testResult.getResult98(),98));
        testResult.setResult99(indexLevel(testResult.getResult99(),99));
        testResult.setResult100(indexLevel(testResult.getResult100(),100));
        testResult.setResult101(indexLevel(testResult.getResult101(),101));
        testResult.setResult102(indexLevel(testResult.getResult102(),102));
        testResult.setResult103(indexLevel(testResult.getResult103(),103));
        testResult.setResult104(indexLevel(testResult.getResult104(),104));
        testResult.setResult105(indexLevel(testResult.getResult105(),105));
        testResult.setResult106(indexLevel(testResult.getResult106(),106));
        testResult.setResult107(indexLevel(testResult.getResult107(),107));
        testResult.setResult108(indexLevel(testResult.getResult108(),108));
        testResult.setResult109(indexLevel(testResult.getResult109(),109));
        testResult.setResult110(indexLevel(testResult.getResult110(),110));
        testResult.setResult111(indexLevel(testResult.getResult111(),111));
        testResult.setResult112(indexLevel(testResult.getResult112(),112));
        testResult.setResult113(indexLevel(testResult.getResult113(),113));
        testResult.setResult114(indexLevel(testResult.getResult114(),114));
        testResult.setResult115(indexLevel(testResult.getResult115(),115));
        testResult.setResult116(indexLevel(testResult.getResult116(),116));
        testResult.setResult117(indexLevel(testResult.getResult117(),117));
        testResult.setResult118(indexLevel(testResult.getResult118(),118));
        testResult.setResult119(indexLevel(testResult.getResult119(),119));
        testResult.setResult120(indexLevel(testResult.getResult120(),120));
        testResult.setResult121(indexLevel(testResult.getResult121(),121));
        testResult.setResult122(indexLevel(testResult.getResult122(),122));
        testResult.setResult123(indexLevel(testResult.getResult123(),123));
        testResult.setResult124(indexLevel(testResult.getResult124(),124));
        testResult.setResult125(indexLevel(testResult.getResult125(),125));
        testResult.setResult126(indexLevel(testResult.getResult126(),126));
        testResult.setResult127(indexLevel(testResult.getResult127(),127));
        testResult.setResult128(indexLevel(testResult.getResult128(),128));
        testResult.setResult129(indexLevel(testResult.getResult129(),129));
        testResult.setResult130(indexLevel(testResult.getResult130(),130));
        System.out.println("指标项等级计算完成");
    }
}

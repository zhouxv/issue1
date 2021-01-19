package com.issue1.demo.util;

import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.entity.SagLevel;

import java.util.ArrayList;
import java.util.List;

import static com.issue1.demo.util.ConvertList.stringToDoubleList;


public class CountSagLevel {
    public static SagLevel setSagLevel(GroupLevel groupLevel) {
        SagLevel sagLevel = new SagLevel();
        sagLevel.setServiceid(groupLevel.getServiceid());
        List<String> sList = new ArrayList<>();
        List<String> aList = new ArrayList<>();
        List<String> gList = new ArrayList<>();

        //访问控制
        sList.add(groupLevel.getAccesscontrol());
        //密码支持
        sList.add(groupLevel.getCryptographicsupport());
        //数据保密性
        sList.add(groupLevel.getDataconfidentiality());
        // 数据完整性
        sList.add(groupLevel.getDataintegrity());
        // 数据和应用可用性
        sList.add(groupLevel.getDataavailability());
        //数据销毁
        sList.add(groupLevel.getDatadestruction());
        //数据备份恢复
        sList.add(groupLevel.getBackuprecovery());
        //电子合同
        sList.add(groupLevel.getElectroniccontract());

        //边界防护
        aList.add(groupLevel.getPerimetersecurity());
        // 身份鉴别
        aList.add(groupLevel.getIdentityauthentication());
        // 入侵防范
        aList.add(groupLevel.getIntrusionprevention());
        // 监控与检测
        aList.add(groupLevel.getMonitordetect());
        //恶意代码防范
        aList.add(groupLevel.getMaliciouscoderesistance());
        // 个人数据恢复
        aList.add(groupLevel.getDataprivacy());
        //事件预警和处置
        aList.add(groupLevel.getEventalert());

        //安全审计与验证
        gList.add(groupLevel.getSecurityvalidation());
        //机构配置管理
        gList.add(groupLevel.getOrganizationalmanagement());
        //剩余信息保护
        gList.add(groupLevel.getRedundancycleanup());
        //安全策略
        gList.add(groupLevel.getSecuritypolicy());
        //管理制度
        gList.add(groupLevel.getSystemmanagement());
        //安全日志
        gList.add(groupLevel.getSecuritylog());
        //流程管理
        gList.add(groupLevel.getProcessmanagement());
        //服务协议
        gList.add(groupLevel.getServiceagreement());

        System.out.println("S等级");
        sagLevel.setSresult(
                totalCount(sList, new double[]{1, 1, 1, 1, 1, 1, 1, 1}, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        );
        System.out.println("A等级");
        sagLevel.setAresult(
                totalCount(aList, new double[]{1, 1, 1, 1, 1, 1, 1}, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        );
        System.out.println("G等级");
        sagLevel.setGresult(
                totalCount(gList, new double[]{1, 1, 1, 1, 1, 1, 1, 1}, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        );
        sagLevel.setLevel(countFinalLevel(sagLevel.getSresult(), sagLevel.getAresult(), sagLevel.getGresult()));
        return sagLevel;
    }

    public static String totalCount(List<String> stringList, double[] weightArray, List<Double> levelList1, List<Double> levelList2, List<Double> levelList3, List<Double> levelList4) {
        for (int i = 0; i < weightArray.length; i++) {
            List<Double> list = stringToDoubleList(stringList.get(i));
            levelList1.add(list.get(0));
            levelList2.add(list.get(1));
            levelList3.add(list.get(2));
            levelList4.add(list.get(3));
        }
        Double[] doubles = {oneSagLevel(levelList1, weightArray), oneSagLevel(levelList2, weightArray), oneSagLevel(levelList3, weightArray), oneSagLevel(levelList4, weightArray)};
        for (int i = 0; i < 4; i++) {
            System.out.println("第" + (i + 1) + "级得分" + doubles[i]);
        }
        return doubles[0] + "," + doubles[1] + "," + doubles[2] + "," + doubles[3] + "," + sagLevel(doubles);
    }

    /**
     * 根据权重和某个等级上安全族的得分，算出当前等级S/A/G的得分
     *
     * @param doubleList  List<Double> 某等级所有指标得分的list
     * @param weightArray double[] 对应指标的权重数组
     * @return double 得分
     */
    public static Double oneSagLevel(List<Double> doubleList, double[] weightArray) {
        double scoreSum = 0;
        double weightSum = 0;
        for (int i = 0; i < weightArray.length; i++) {
            scoreSum = scoreSum + doubleList.get(i) * weightArray[i];
            weightSum = weightSum + weightArray[i];
        }
        return scoreSum / weightSum;
    }

    /**
     * 根据S/A/G类的四个等级上的得分,得到对应的等级
     *
     * @param doubles Double[] 四个等级的得分
     * @return String 等级
     */
    public static String sagLevel(Double[] doubles) {
        int level = 0;
        for (Double aDouble : doubles) {
            if (aDouble > 0.9) {
                level++;
                continue;
            }
            break;
        }
        return "" + level;
    }

    /**
     * 根据四个等级上的SAG得分计算其等级
     *
     * @param s String S类四个等级的得分和最终等级
     * @param a String A类四个等级的得分和最终等级
     * @param g String G类四个等级的得分和最终等级
     * @return String 最终等级
     */
    public static String countFinalLevel(String s, String a, String g) {
        List<Double> sDoubleList = stringToDoubleList(s);
        List<Double> aDoubleList = stringToDoubleList(a);
        List<Double> gDoubleList = stringToDoubleList(g);
        if (sDoubleList.size() != 5 & aDoubleList.size() != 5 & gDoubleList.size() != 5) return "sag类数据格式错误";
        Double sum = sDoubleList.get(sDoubleList.size() - 1) + aDoubleList.get(aDoubleList.size() - 1) + gDoubleList.get(gDoubleList.size() - 1);
        System.out.println("sum=" + sum);
        if (sum < 3 & sum >= 0) return "未达到最低等级";
        if (sum == 3) return "基础定义级";
        if (sum > 3 & sum <= 6) return "增强控制级";
        if (sum > 6 & sum <= 9) return "持续优化级";
        if (sum > 9 & sum <= 12) return "量化完善级";
        return "未知等级";
    }
}

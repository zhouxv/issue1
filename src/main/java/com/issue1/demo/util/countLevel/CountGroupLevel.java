package com.issue1.demo.util.countLevel;

import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.entity.TestResult;

import java.util.ArrayList;
import java.util.List;

import static com.issue1.demo.util.ConvertList.*;


public class CountGroupLevel {
    /**
     * 根据testResult设置groupLevel的23个安全族的最终得分与等级
     *
     * @param testResult TestResult 测试结果
     * @return groupLevel GroupLevel 安全族等级
     */
    public static GroupLevel countGroupLevel(TestResult testResult) {
        GroupLevel groupLevel = new GroupLevel();
        groupLevel.setServiceid(testResult.getServiceid());
        List<String> listTestResult = convertTestResult(testResult);
        //23个安全族，对应groupLevel 23个变量成员，每个安全族都有队友

        //边界防护,1
        //System.out.println("边界防护安全等级");
        groupLevel.setPerimetersecurity(
                totalCount(
                        listTestResult, new double[]{1, 1, 0.7, 1, 1}, 0, 5
                )
        );
        //访问控制,2
        //System.out.println("访问控制安全等级");
        groupLevel.setAccesscontrol(
                totalCount(
                        listTestResult, new double[]{1, 0.7, 1, 1, 1, 0.7, 0.7, 0.7, 1, 1, 0.7, 1, 1}, 5, 13
                )
        );
        //身份鉴别,3
        //System.out.println("身份鉴别安全等级");
        groupLevel.setIdentityauthentication(
                totalCount(
                        listTestResult, new double[]{1, 1, 0.7, 1}, 18, 4
                )
        );
        //密码支持,4
        //System.out.println("密码支持安全等级");
        groupLevel.setCryptographicsupport(
                totalCount(
                        listTestResult, new double[]{1, 1, 0.7, 0.7}, 22, 4
                )
        );
        //入侵防范,5
        //System.out.println("入侵防范安全等级");
        groupLevel.setIntrusionprevention(
                totalCount(
                        listTestResult, new double[]{1, 1, 0.7, 0.7}, 26, 4
                )
        );
        //监控与检测,6
        //System.out.println("监控与检测安全等级");
        groupLevel.setMonitordetect(
                totalCount(
                        listTestResult, new double[]{0.4, 0.7, 1, 0.4, 0.7}, 30, 5
                )
        );
        //恶意代码防范,7
        //System.out.println("恶意代码防范安全等级");
        groupLevel.setMaliciouscoderesistance(
                totalCount(
                        listTestResult, new double[]{1, 1, 1}, 35, 3
                )
        );
        //数据保密性,8
        //System.out.println("数据保密性安全等级");
        groupLevel.setDataconfidentiality(
                totalCount(
                        listTestResult, new double[]{1, 1}, 38, 2
                )
        );
        //数据完整性,9
        //System.out.println("数据完整性安全等级");
        groupLevel.setDataintegrity(
                totalCount(
                        listTestResult, new double[]{0.7, 1, 1, 0.4, 0.7, 0.4}, 40, 6
                )
        );
        //数据和应用可用性,10
        //System.out.println("数据和应用可用性安全等级");
        groupLevel.setDataavailability(
                totalCount(
                        listTestResult, new double[]{0.7, 1, 1, 1, 1}, 46, 5
                )
        );
        //数据销毁,11
        //System.out.println("数据销毁安全等级");
        groupLevel.setDatadestruction(
                totalCount(
                        listTestResult, new double[]{0.7, 0.7, 0.4}, 51, 3
                )
        );
        //数据备份恢复,12
        //System.out.println("数据备份恢复安全等级");
        groupLevel.setBackuprecovery(
                totalCount(
                        listTestResult, new double[]{1, 0.7, 0.7, 0.4, 0.7, 0.4, 0.4}, 54, 7
                )
        );
        //个人数据处理,13
        //System.out.println("个人数据处理安全等级");
        groupLevel.setDataprivacy(
                totalCount(
                        listTestResult, new double[]{0.7, 0.7}, 61, 2
                )
        );
        //安全审计与验证,14
        //System.out.println("安全审计与验证安全等级");
        groupLevel.setSecurityvalidation(
                totalCount(
                        listTestResult, new double[]{0.7, 0.7, 0.7, 0.4, 0.7, 0.7}, 63, 6
                )
        );
        //机构配置管理,15
        //System.out.println("机构配置管理安全等级");
        groupLevel.setOrganizationalmanagement(
                totalCount(
                        listTestResult, new double[]{0.7, 0.4, 0.7, 0.7, 0.7, 0.4, 0.7, 0.4, 1, 1, 1, 1, 0.7, 0.7, 0.7}, 69, 15
                )
        );
        //剩余信息保护,16
        //System.out.println("剩余信息保护安全等级");
        groupLevel.setRedundancycleanup(
                totalCount(
                        listTestResult, new double[]{1, 1}, 84, 2
                )
        );
        //安全策略,17
        //System.out.println("安全策略安全等级");
        groupLevel.setSecuritypolicy(
                totalCount(
                        listTestResult, new double[]{0.4, 1, 1, 0.7, 0.7, 0.7, 0.7, 1, 0.7, 0.7, 0.4, 1, 0.4, 1, 1, 0.7}, 86, 16
                )
        );
        //事件预警和处置,18
        //System.out.println("事件预警和处置安全等级");
        groupLevel.setEventalert(
                totalCount(
                        listTestResult, new double[]{1, 0.7, 0.7}, 102, 3
                )
        );
        //管理制度,19
        //System.out.println("管理制度安全等级");
        groupLevel.setSystemmanagement(
                totalCount(
                        listTestResult, new double[]{1, 0.4, 0.7, 1, 1, 0.7, 0.4}, 105, 7
                )
        );
        //安全日志,20
        //System.out.println("安全日志安全等级");
        groupLevel.setSecuritylog(
                totalCount(
                        listTestResult, new double[]{1, 0.7, 0.4, 1, 0.7}, 112, 5
                )
        );
        //流程管理,21
        //System.out.println("流程管理安全等级");
        groupLevel.setProcessmanagement(
                totalCount(
                        listTestResult, new double[]{1, 1, 1}, 117, 3
                )
        );
        //服务协议,22
        //System.out.println("服务协议安全等级");
        groupLevel.setServiceagreement(
                totalCount(
                        listTestResult, new double[]{0.7, 1, 1, 1, 1}, 120, 5
                )
        );
        //电子合同,23
        //System.out.println("电子合同安全等级");
        groupLevel.setElectroniccontract(
                totalCount(
                        listTestResult, new double[]{1, 1, 1, 1, 1}, 125, 5
                )
        );

        System.out.println("ServiceId " + testResult.getServiceid() + " :GroupLevel计算完成");
        return groupLevel;
    }

    /*
     */
    public static String totalCount(List<String> listGroupLevel, double[] weightArray, int start, int length) {
        return sample(listGroupLevel, weightArray, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), start, length);
    }

    /**
     * 具体的计算过程，先把数据整理好，然后调用oneGroupLevel，再调用groupLevel
     *
     * @param listGroupLevel List<String>
     * @param weightArray    double[] 对应指标的权重数组
     * @return double 得分
     */
    public static String sample(List<String> listGroupLevel, double[] weightArray, List<Double> levelList1, List<Double> levelList2, List<Double> levelList3, List<Double> levelList4, int start, int length) {
        for (int i = start; i < start+length; i++) {
            List<Double> list = stringToDoubleList(listGroupLevel.get(i));
//            System.out.println("第" + i + "个指标有" + list.size() + "个数据");
            levelList1.add(list.get(0) / list.get(1));
            levelList2.add(list.get(2) / list.get(3));
            levelList3.add(list.get(4) / list.get(5));
            levelList4.add(list.get(6) / list.get(7));
        }

//        System.out.println("start=" + start + "，length=" + length + "，存了" + levelList1.size() + "个分");
        Double[] doubles = {oneGroupLevel(levelList1, weightArray), oneGroupLevel(levelList2, weightArray), oneGroupLevel(levelList3, weightArray), oneGroupLevel(levelList4, weightArray)};
        return groupLevel(doubles);
    }

    /**
     * 根据四个等级上的得分计算某个安全族的最终等级
     *
     * @param doubles Double[] 四个等级的得分
     * @return String 四个等级的得分和最终等级，逗号分隔
     */
    public static String groupLevel(Double[] doubles) {
        String groupLevel ="";
        int level = 0;
        for (Double aDouble : doubles) {
            groupLevel = groupLevel + aDouble + ",";
        }
        for (Double aDouble : doubles) {
            if (aDouble > 0.8) {
                level++;
                continue;
            }
            break;
        }
        return groupLevel + level;
    }

    /**
     * 根据权重和某个等级上的每个指标的得分，算出当前等级该安全族的得分
     *
     * @param doubleList  List<Double> 某等级所有指标得分的list
     * @param weightArray double[] 对应指标的权重数组
     * @return double 得分
     */
    public static Double oneGroupLevel(List<Double> doubleList, double[] weightArray) {
        double scoreSum = 0;
        double weightSum = 0;
        for (int i = 0; i < weightArray.length; i++) {
            scoreSum = scoreSum + doubleList.get(i) * weightArray[i];
            weightSum = weightSum + weightArray[i];
        }
        return formatDouble(scoreSum / weightSum);
    }
}

package com.issue1.demo.util;

import com.issue1.demo.entity.Issue2Result;
import com.issue1.demo.entity.Issue2ResultDetail;
import com.issue1.demo.entity.Service;
import com.issue1.demo.entity.TestResult;
import com.issue1.demo.utilEntity.issue2ResultUtil.Issue2ResultDetailUtil;
import com.issue1.demo.utilEntity.issue2ResultUtil.Issue2ResultUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Issue2Util {
    public static Service issue2ResultToService(Issue2Result issue2Result) {
        Service service = new Service();
        service.setServicecompany(issue2Result.getCompanyName());
        service.setServicetype(issue2Result.getServiceType());
        service.setServicename(issue2Result.getBusinessName());
        service.setTestorganization(issue2Result.getEvaluator());
        service.setIssue2resultid(issue2Result.getIssue2resultid());
        return service;
    }

    /*
    生成数据随机的testResult
     */
    public static TestResult generateIssue2TestResult(Service service) {
        TestResult testResult = new TestResult();
        testResult.setServiceid(service.getServiceid());

        testResult.setResult1(generateResultString());
        testResult.setResult2(generateResultString());
        testResult.setResult3(generateResultString());
        testResult.setResult4(generateResultString());
        testResult.setResult5(generateResultString());
        testResult.setResult6(generateResultString());
        testResult.setResult7(generateResultString());
        testResult.setResult8(generateResultString());
        testResult.setResult9(generateResultString());
        testResult.setResult10(generateResultString());
        testResult.setResult11(generateResultString());
        testResult.setResult12(generateResultString());
        testResult.setResult13(generateResultString());
        testResult.setResult14(generateResultString());
        testResult.setResult15(generateResultString());
        testResult.setResult16(generateResultString());
        testResult.setResult17(generateResultString());
        testResult.setResult18(generateResultString());
        testResult.setResult19(generateResultString());
        testResult.setResult20(generateResultString());
        testResult.setResult21(generateResultString());
        testResult.setResult22(generateResultString());
        testResult.setResult23(generateResultString());
        testResult.setResult24(generateResultString());
        testResult.setResult25(generateResultString());
        testResult.setResult26(generateResultString());
        testResult.setResult27(generateResultString());
        testResult.setResult28(generateResultString());
        testResult.setResult29(generateResultString());
        testResult.setResult30(generateResultString());
        testResult.setResult31(generateResultString());
        testResult.setResult32(generateResultString());
        testResult.setResult33(generateResultString());
        testResult.setResult34(generateResultString());
        testResult.setResult35(generateResultString());
        testResult.setResult36(generateResultString());
        testResult.setResult37(generateResultString());
        testResult.setResult38(generateResultString());
        testResult.setResult39(generateResultString());
        testResult.setResult40(generateResultString());
        testResult.setResult41(generateResultString());
        testResult.setResult42(generateResultString());
        testResult.setResult43(generateResultString());
        testResult.setResult44(generateResultString());
        testResult.setResult45(generateResultString());
        testResult.setResult46(generateResultString());
        testResult.setResult47(generateResultString());
        testResult.setResult48(generateResultString());
        testResult.setResult49(generateResultString());
        testResult.setResult50(generateResultString());
        testResult.setResult51(generateResultString());
        testResult.setResult52(generateResultString());
        testResult.setResult53(generateResultString());
        testResult.setResult54(generateResultString());
        testResult.setResult55(generateResultString());
        testResult.setResult56(generateResultString());
        testResult.setResult57(generateResultString());
        testResult.setResult58(generateResultString());
        testResult.setResult59(generateResultString());
        testResult.setResult60(generateResultString());
        testResult.setResult61(generateResultString());
        testResult.setResult62(generateResultString());
        testResult.setResult63(generateResultString());
        testResult.setResult64(generateResultString());
        testResult.setResult65(generateResultString());
        testResult.setResult66(generateResultString());
        testResult.setResult67(generateResultString());
        testResult.setResult68(generateResultString());
        testResult.setResult69(generateResultString());
        testResult.setResult70(generateResultString());
        testResult.setResult71(generateResultString());
        testResult.setResult72(generateResultString());
        testResult.setResult73(generateResultString());
        testResult.setResult74(generateResultString());
        testResult.setResult75(generateResultString());
        testResult.setResult76(generateResultString());
        testResult.setResult77(generateResultString());
        testResult.setResult78(generateResultString());
        testResult.setResult79(generateResultString());
        testResult.setResult80(generateResultString());
        testResult.setResult81(generateResultString());
        testResult.setResult82(generateResultString());
        testResult.setResult83(generateResultString());
        testResult.setResult84(generateResultString());
        testResult.setResult85(generateResultString());
        testResult.setResult86(generateResultString());
        testResult.setResult87(generateResultString());
        testResult.setResult88(generateResultString());
        testResult.setResult89(generateResultString());
        testResult.setResult90(generateResultString());
        testResult.setResult91(generateResultString());
        testResult.setResult92(generateResultString());
        testResult.setResult93(generateResultString());
        testResult.setResult94(generateResultString());
        testResult.setResult95(generateResultString());
        testResult.setResult96(generateResultString());
        testResult.setResult97(generateResultString());
        testResult.setResult98(generateResultString());
        testResult.setResult99(generateResultString());
        testResult.setResult100(generateResultString());
        testResult.setResult101(generateResultString());
        testResult.setResult102(generateResultString());
        testResult.setResult103(generateResultString());
        testResult.setResult104(generateResultString());
        testResult.setResult105(generateResultString());
        testResult.setResult106(generateResultString());
        testResult.setResult107(generateResultString());
        testResult.setResult108(generateResultString());
        testResult.setResult109(generateResultString());
        testResult.setResult110(generateResultString());
        testResult.setResult111(generateResultString());
        testResult.setResult112(generateResultString());
        testResult.setResult113(generateResultString());
        testResult.setResult114(generateResultString());
        testResult.setResult115(generateResultString());
        testResult.setResult116(generateResultString());
        testResult.setResult117(generateResultString());
        testResult.setResult118(generateResultString());
        testResult.setResult119(generateResultString());
        testResult.setResult120(generateResultString());
        testResult.setResult121(generateResultString());
        testResult.setResult122(generateResultString());
        testResult.setResult123(generateResultString());
        testResult.setResult124(generateResultString());
        testResult.setResult125(generateResultString());
        testResult.setResult126(generateResultString());
        testResult.setResult127(generateResultString());
        testResult.setResult128(generateResultString());
        testResult.setResult129(generateResultString());
        testResult.setResult130(generateResultString());
        return testResult;
    }

    /*
    生成某个指标项上的随机测试结果
     */
    public static String generateResultString() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        int a, b, c;
        stringBuffer.append("1,1,");

        a = 1 + random.nextInt(3);
        stringBuffer.append(a);
        stringBuffer.append(",2,");

        b = a + random.nextInt(2);
        stringBuffer.append(b);
        stringBuffer.append(",3,");

        c = b + random.nextInt(2);
        stringBuffer.append(c);
        stringBuffer.append(",4");

        return stringBuffer.toString();
    }

    /*
   将List<Issue2ResultDetailUtil>转换为List<Issue2ResultDetail>
    */
    public static List<Issue2ResultDetail> detailListConvert(List<Issue2ResultDetailUtil> list) {
        List<Issue2ResultDetail> detailList = new ArrayList<>();
        for (Issue2ResultDetailUtil issue2ResultDetailUtil : list) {
            detailList.add(utilToIssue2ResultDetail(issue2ResultDetailUtil));
        }
        return detailList;
    }

    public static Issue2ResultDetail utilToIssue2ResultDetail(Issue2ResultDetailUtil issue2ResultDetailUtil) {
        Issue2ResultDetail issue2ResultDetail = new Issue2ResultDetail();
        issue2ResultDetail.setConf(issue2ResultDetailUtil.conf);
        issue2ResultDetail.setIndex(issue2ResultDetailUtil.index);
        issue2ResultDetail.setIndex_item(issue2ResultDetailUtil.index_item);
        issue2ResultDetail.setSecure_group(issue2ResultDetailUtil.secure_group);
        System.out.println();
        switch (issue2ResultDetailUtil.level) {
            case "基础定义级": {
                issue2ResultDetail.setGrade(1);
            }
            case "增强控制级": {
                issue2ResultDetail.setGrade(2);
            }
            case "持续优化级": {
                issue2ResultDetail.setGrade(3);
            }
            case "量化完善级": {
                issue2ResultDetail.setGrade(4);
            }
        }
        return issue2ResultDetail;
    }

    /*
    由于接口字段命名格式驼峰和下划线混杂
    mapper会出问题
    所以使用了Issue2ResultUtil来接收课题二的结果

    该类用于将Issue2ResultUtil转换成Issue2Result

     */
    public static Issue2Result utilToIssue2Result(Issue2ResultUtil issue2ResultUtil) {
        Issue2Result issue2Result = new Issue2Result();
        issue2Result.setServiceIDtestID(issue2ResultUtil.serviceID_TestID);
        issue2Result.setBusinessName(issue2ResultUtil.business_name);
        issue2Result.setCompanyName(issue2ResultUtil.company_name);
        issue2Result.setBusinessIntroduce(issue2ResultUtil.business_introduce);
        issue2Result.setEvaluator(issue2ResultUtil.evaluator);
        issue2Result.setEvaluationTime(issue2ResultUtil.evaluation_time);
        issue2Result.setEvaluationAddr(issue2ResultUtil.evaluation_addr);
        issue2Result.setServiceType(issue2ResultUtil.serviceType);
        issue2Result.setLevel(issue2ResultUtil.level);
        issue2Result.setEvaluation_results(detailListConvert(issue2ResultUtil.evaluation_results));
        return issue2Result;
    }
}

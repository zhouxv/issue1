package com.issue1.demo.util;

import com.issue1.demo.entity.*;
import com.issue1.demo.utilEntity.*;

import java.util.ArrayList;
import java.util.List;

import static com.issue1.demo.util.ConvertList.stringToDoubleArray2;

/*
@Note：

@User：NineSun
@Time:2021/1/29   0:08
*/
public class Issue5Util {
    public static Issue5ResultUtil geneIssue5ResultUtil(Issue2Result issue2Result, Service service, TestResult testResult, GroupLevel groupLevel, SagLevel sagLevel, List<Issue2ResultDetail>... issue2ResultDetailList) {
        Issue5ResultUtil issue5ResultUtil = new Issue5ResultUtil();
        issue5ResultUtil.setService_category(service.getServicetype());
        issue5ResultUtil.setServiceID_testID(issue2Result.getServiceIDtestID());
        issue5ResultUtil.setIssue1result(geneIssue5Result_1(service, sagLevel, groupLevel));
        issue5ResultUtil.setIssue2result(geneIssue5Result_2(issue2Result, issue2ResultDetailList));
        return issue5ResultUtil;
    }

    public static Issue5Result_1 geneIssue5Result_1(Service service, SagLevel sagLevel, GroupLevel groupLevel) {
        Issue5Result_1 issue5Result1 = new Issue5Result_1();
        issue5Result1.setTopLevel(new Issue1TopLevel(service.getServicelevel()));
        issue5Result1.setSagLevel(convertToIssue1SagLevel(sagLevel));
        issue5Result1.setGroupLevel(convertToIssue1GroupLevel(groupLevel));
        return issue5Result1;
    }

    public static Issue1SagLevel convertToIssue1SagLevel(SagLevel sagLevel) {
        Issue1SagLevel issue1SagLevel = new Issue1SagLevel();
        Double[] sResult = stringToDoubleArray2(sagLevel.getSresult());
        Double[] aResult = stringToDoubleArray2(sagLevel.getAresult());
        Double[] gResult = stringToDoubleArray2(sagLevel.getGresult());
        issue1SagLevel.setLevel("S" + sResult[4].intValue() + "A" + aResult[4].intValue() + "G" + gResult[4].intValue());
        issue1SagLevel.setsLevel(new Issue1SagLevelDetail(sResult));
        issue1SagLevel.setaLevel(new Issue1SagLevelDetail(aResult));
        issue1SagLevel.setgLevel(new Issue1SagLevelDetail(gResult));
        return issue1SagLevel;
    }

    public static List<Issue1GroupLevel> convertToIssue1GroupLevel(GroupLevel groupLevel) {
        List<Issue1GroupLevel> issue1GroupLevels = new ArrayList<>();
        String[] groups = new String[]{"边界防护", "访问控制", "身份鉴别", "密码支持", "入侵防范", "监控与检测", "恶意代码防范", "数据保密性", "数据完整性", "数据和应用可用性", "数据销毁", "数据备份恢复", "个人数据处理", "安全审计与验证", "机构配置管理", "剩余信息保护", "安全策略", "事件预警和处置", "管理制度", "安全日志", "流程管理", "服务协议", "电子合同",};
        List<Double[]> list = new ArrayList<>();

        list.add(stringToDoubleArray2(groupLevel.getPerimetersecurity()));
        list.add(stringToDoubleArray2(groupLevel.getAccesscontrol()));
        list.add(stringToDoubleArray2(groupLevel.getIdentityauthentication()));
        list.add(stringToDoubleArray2(groupLevel.getCryptographicsupport()));
        list.add(stringToDoubleArray2(groupLevel.getIntrusionprevention()));
        list.add(stringToDoubleArray2(groupLevel.getMonitordetect()));
        list.add(stringToDoubleArray2(groupLevel.getMaliciouscoderesistance()));
        list.add(stringToDoubleArray2(groupLevel.getDataconfidentiality()));
        list.add(stringToDoubleArray2(groupLevel.getDataintegrity()));
        list.add(stringToDoubleArray2(groupLevel.getDataavailability()));
        list.add(stringToDoubleArray2(groupLevel.getDatadestruction()));
        list.add(stringToDoubleArray2(groupLevel.getBackuprecovery()));
        list.add(stringToDoubleArray2(groupLevel.getDataprivacy()));
        list.add(stringToDoubleArray2(groupLevel.getSecurityvalidation()));
        list.add(stringToDoubleArray2(groupLevel.getOrganizationalmanagement()));
        list.add(stringToDoubleArray2(groupLevel.getRedundancycleanup()));
        list.add(stringToDoubleArray2(groupLevel.getSecuritypolicy()));
        list.add(stringToDoubleArray2(groupLevel.getEventalert()));
        list.add(stringToDoubleArray2(groupLevel.getSystemmanagement()));
        list.add(stringToDoubleArray2(groupLevel.getSecuritylog()));
        list.add(stringToDoubleArray2(groupLevel.getProcessmanagement()));
        list.add(stringToDoubleArray2(groupLevel.getServiceagreement()));
        list.add(stringToDoubleArray2(groupLevel.getElectroniccontract()));

        for (int i = 0; i < 23; i++) {
            Issue1GroupLevel issue1GroupLevel = new Issue1GroupLevel();
            issue1GroupLevel.setSecure_group((i + 1) + "");
            issue1GroupLevel.setDescription(groups[i]);
            issue1GroupLevel.setScore(new Score(list.get(i)[0].toString(), list.get(i)[1].toString(), list.get(i)[2].toString(), list.get(i)[3].toString()));
            issue1GroupLevels.add(issue1GroupLevel);
        }
        return issue1GroupLevels;
    }

    public static Issue5Result_2 geneIssue5Result_2(Issue2Result issue2Result, List<Issue2ResultDetail>... issue2ResultDetailList) {
        Issue5Result_2 issue5Result2 = new Issue5Result_2();
        issue5Result2.setCompany_name(issue2Result.getCompanyName());
        issue5Result2.setBusiness_name(issue2Result.getBusinessName());
        issue5Result2.setBusiness_introduce(issue2Result.getBusinessIntroduce());
        issue5Result2.setEvaluator(issue2Result.getEvaluator());
        issue5Result2.setEvaluation_time(issue2Result.getEvaluationTime());
        issue5Result2.setEvaluationa_addr(issue2Result.getEvaluationAddr());
        issue5Result2.setEvalution_results(convertToEvalutionResults(issue2ResultDetailList));
        return issue5Result2;
    }

    public static EvalutionResults convertToEvalutionResults(List<Issue2ResultDetail>... issue2ResultDetailList) {
        EvalutionResults evalutionResults = new EvalutionResults();

        evalutionResults.setLevel_1(convertToEvalutionResults(issue2ResultDetailList[0]));
        evalutionResults.setLevel_2(convertToEvalutionResults(issue2ResultDetailList[1]));
        evalutionResults.setLevel_3(convertToEvalutionResults(issue2ResultDetailList[2]));
        evalutionResults.setLevel_4(convertToEvalutionResults(issue2ResultDetailList[3]));

        return evalutionResults;
    }

    public static List<EvalutionResult> convertToEvalutionResults(List<Issue2ResultDetail> issue2ResultDetailList) {
        List<EvalutionResult> list = new ArrayList<>();
        if (issue2ResultDetailList.isEmpty()) return list;
        for (Issue2ResultDetail issue2ResultDetail : issue2ResultDetailList) {
            list.add(new EvalutionResult(issue2ResultDetail.getIndex().toString(), issue2ResultDetail.getConf()));
        }
        return list;
    }
}
package com.issue1.demo.util;

import com.issue1.demo.entity.*;
import com.issue1.demo.utilEntity.issue5ResultUtil.*;

import java.util.ArrayList;
import java.util.List;

import static com.issue1.demo.util.ConvertList.convertGroupLevel;
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
        issue5ResultUtil.setIuuse1result(geneIssue5Result_1(service, sagLevel, groupLevel));
        issue5ResultUtil.setIuuse2result(geneIssue5Result_2(issue2Result, issue2ResultDetailList));
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
        List<String> stringList = convertGroupLevel(groupLevel);
        List<Double[]> list = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            list.add(stringToDoubleArray2(stringList.get(i)));
        }

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
        issue5Result2.setEvalution_results(convertToEvaluationResults(issue2ResultDetailList));
        return issue5Result2;
    }

    public static EvaluationResults convertToEvaluationResults(List<Issue2ResultDetail>... issue2ResultDetailList) {
        EvaluationResults evaluationResults = new EvaluationResults();

        evaluationResults.setLevel_1(convertToEvaluationResults(issue2ResultDetailList[0]));
        evaluationResults.setLevel_2(convertToEvaluationResults(issue2ResultDetailList[1]));
        evaluationResults.setLevel_3(convertToEvaluationResults(issue2ResultDetailList[2]));
        evaluationResults.setLevel_4(convertToEvaluationResults(issue2ResultDetailList[3]));

        return evaluationResults;
    }

    public static List<EvaluationResult> convertToEvaluationResults(List<Issue2ResultDetail> issue2ResultDetailList) {
        List<EvaluationResult> list = new ArrayList<>();
        if (issue2ResultDetailList.isEmpty()) return list;
        for (Issue2ResultDetail issue2ResultDetail : issue2ResultDetailList) {
            list.add(new EvaluationResult(issue2ResultDetail.getIndex().toString(), issue2ResultDetail.getConf()));
        }
        return list;
    }
}

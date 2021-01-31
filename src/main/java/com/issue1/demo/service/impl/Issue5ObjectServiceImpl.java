package com.issue1.demo.service.impl;

import com.issue1.demo.entity.*;
import com.issue1.demo.service.*;
import com.issue1.demo.utilEntity.issue5ResultUtil.Issue5ResultUtil;

import java.util.ArrayList;
import java.util.List;

import static com.issue1.demo.util.Issue5Util.geneIssue5ResultUtil;

@org.springframework.stereotype.Service
public class Issue5ObjectServiceImpl implements IIssue5ObjectService {
    private final IServiceService serviceService;
    private final ITestResultService testResultService;
    private final IGroupLevelService groupLevelService;
    private final ISagLevelService sagLevelService;
    private final IIssue2ResultService issue2ResultService;
    private final IIssue2ResultDetailService iIssue2ResultDetailService;

    public Issue5ObjectServiceImpl(IServiceService serviceService, ITestResultService testResultService, IGroupLevelService groupLevelService, ISagLevelService sagLevelService, IIssue2ResultService issue2ResultService, IIssue2ResultDetailService iIssue2ResultDetailService) {
        this.serviceService = serviceService;
        this.testResultService = testResultService;
        this.groupLevelService = groupLevelService;
        this.sagLevelService = sagLevelService;
        this.issue2ResultService = issue2ResultService;
        this.iIssue2ResultDetailService = iIssue2ResultDetailService;
    }

    @Override
    public List<Issue5ResultUtil> geneIssue5ResultUtils(Issue2Result issue2Result) {
        List<Issue2Result> issue2Results = this.issue2ResultService.findIssue2ResultsBySTId(issue2Result);
        List<Issue5ResultUtil> issue5ResultUtils = new ArrayList<>();
        if (issue2Results.size() == 0) return issue5ResultUtils;
        for (Issue2Result result : issue2Results) {
            List<Issue2ResultDetail> issue2ResultDetailList1 = this.iIssue2ResultDetailService.findIssue2ResultDetails(result.getServiceIDtestID(), 1);
            List<Issue2ResultDetail> issue2ResultDetailList2 = this.iIssue2ResultDetailService.findIssue2ResultDetails(result.getServiceIDtestID(), 2);
            List<Issue2ResultDetail> issue2ResultDetailList3 = this.iIssue2ResultDetailService.findIssue2ResultDetails(result.getServiceIDtestID(), 3);
            List<Issue2ResultDetail> issue2ResultDetailList4 = this.iIssue2ResultDetailService.findIssue2ResultDetails(result.getServiceIDtestID(), 4);
            Service service = this.serviceService.findOneServiceByIssue2ResultId(result.getIssue2resultid());
            TestResult testResult = this.testResultService.findOneTestResultByServiceId(service.getServiceid());
            GroupLevel groupLevel = this.groupLevelService.findOneGroupLevel(service.getServiceid());
            SagLevel sagLevel = this.sagLevelService.findOneSagLevel(service.getServiceid());
            issue5ResultUtils.add(geneIssue5ResultUtil(result, service, testResult, groupLevel, sagLevel, issue2ResultDetailList1, issue2ResultDetailList2, issue2ResultDetailList3, issue2ResultDetailList4));
        }
        return issue5ResultUtils;
    }
}

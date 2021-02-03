package com.issue1.demo.controller;

import com.issue1.demo.entity.*;
import com.issue1.demo.service.businessService.IIssue5Service;
import com.issue1.demo.service.entityService.*;
import com.issue1.demo.util.countLevel.CountIndexLevel;
import com.issue1.demo.util.countLevel.CountSagLevel;
import com.issue1.demo.utilEntity.issue2ResultUtil.Issue2ResultUtil;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.issue1.demo.util.Issue2Util.*;
import static com.issue1.demo.util.countLevel.CountGroupLevel.countGroupLevel;

/**
 * Controller
 *
 * @author zhouxv
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"issue2"})
public class Issue2Controller extends BaseController {
    private final IServiceService serviceService;
    private final ITestResultService testResultService;
    private final IGroupLevelService groupLevelService;
    private final ISagLevelService sagLevelService;
    private final IIssue2ResultService issue2ResultService;
    private final IIssue2ResultDetailService iIssue2ResultDetailService;
    private final IIssue5Service issue5Service;

    public Issue2Controller(IIssue2ResultService issue2ResultService, IIssue2ResultDetailService iIssue2ResultDetailService, IServiceService serviceService, ITestResultService testResultService, IGroupLevelService groupLevelService, ISagLevelService sagLevelService, IIssue5Service issue5Service) {
        this.serviceService = serviceService;
        this.testResultService = testResultService;
        this.groupLevelService = groupLevelService;
        this.sagLevelService = sagLevelService;
        this.issue2ResultService = issue2ResultService;
        this.iIssue2ResultDetailService = iIssue2ResultDetailService;
        this.issue5Service = issue5Service;
    }

//    @GetMapping("test")
//    public ResponseBo test() {
//        Object o=this.issue5Service.accessIssue5API("http://localhost:10080/issue1/issue2/add","1_1");
//        return ResponseBo.ok(o);
//    }

    @GetMapping({"getAll"})
    public ResponseBo getAllIssue2Results() {
        List<Issue2Result> data = this.issue2ResultService.findIssue2Results();
        return ResponseBo.ok(data);
    }

    @GetMapping({"getOne"})
    public ResponseBo getOneIssue2Result(Integer issue2ResultId, String serviceIDtestID) {
        Issue2Result issue2Result = new Issue2Result(issue2ResultId, serviceIDtestID);
        issue2Result = this.issue2ResultService.findOneIssue2Result(issue2Result);
        return ResponseBo.ok(issue2Result);
    }


    @GetMapping({"getAllDetail"})
    public ResponseBo getAllIssue2ResultDetails() {
        List<Issue2ResultDetail> data = this.iIssue2ResultDetailService.findIssue2ResultDetails();
        return ResponseBo.ok(data);
    }

    @GetMapping({"getAllDetailBy"})
    public ResponseBo getAllIssue2ResultDetails(Integer issue2ResultId, String serviceIDtestID, Integer grade) {
        Issue2ResultDetail issue2ResultDetail = new Issue2ResultDetail(issue2ResultId, serviceIDtestID, grade);
        List<Issue2ResultDetail> data = this.iIssue2ResultDetailService.findIssue2ResultDetails(issue2ResultDetail);
        return ResponseBo.ok(data);
    }

    @PostMapping({"add"})
    public ResponseBo addService(@Validated @RequestBody Issue2ResultUtil issue2ResultUtil, BindingResult bindingResult) {
        //格式校验，出问题会将问题返回
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError allError : bindingResult.getAllErrors()) {
                stringBuffer.append(allError.getDefaultMessage()).append(";");
            }
            return ResponseBo.fail(stringBuffer.toString());
        }

        //课题二接口字段与系统内部不统一，使用utilToIssue2Result函数来把issue2ResultUtil转换为issue2Result
        Issue2Result issue2Result = utilToIssue2Result(issue2ResultUtil);

        Issue2Result issue2Result1 = this.issue2ResultService.findOneIssue2Result(issue2Result);

        if (!(issue2Result1 == null)) {
            List<Issue2ResultDetail> issue2ResultDetailList = this.iIssue2ResultDetailService.findIssue2ResultDetails(issue2Result.getServiceIDtestID(), issue2Result.getLevel());
            if (!issue2ResultDetailList.isEmpty())
                return ResponseBo.fail("ServiceId_TestId = " + issue2Result1.getServiceIDtestID() + " 的 " + issue2Result1.getLevel() + " 级测试结果已提交，请勿重复提交");


            List<Issue2ResultDetail> list = issue2Result.getEvaluation_results();

            for (Issue2ResultDetail issue2ResultDetail : list) {
                issue2ResultDetail.setIssue2resultid(issue2Result1.getIssue2resultid());
                issue2ResultDetail.setServiceIDtestID(issue2Result.getServiceIDtestID());
            }

            if (!this.iIssue2ResultDetailService.createIssue2ResultDetailBatch(list))
                ResponseBo.fail("issue2ResultDetail添加失败");

            return ResponseBo.ok("serviceid_testid = " + issue2Result1.getServiceIDtestID() + " 的数据补充成功");
        }

        if (!this.issue2ResultService.createIssue2Result(issue2Result))
            ResponseBo.fail("issue2Result添加失败");

        List<Issue2ResultDetail> list = issue2Result.getEvaluation_results();

        for (Issue2ResultDetail issue2ResultDetail : list) {
            issue2ResultDetail.setIssue2resultid(issue2Result.getIssue2resultid());
            issue2ResultDetail.setServiceIDtestID(issue2Result.getServiceIDtestID());
        }

        if (!this.iIssue2ResultDetailService.createIssue2ResultDetailBatch(list))
            ResponseBo.fail("issue2ResultDetail添加失败");

        Service service = issue2ResultToService(issue2Result);
        if (!this.serviceService.createService(service))
            ResponseBo.fail("service添加失败");

        TestResult testResult = generateIssue2TestResult(service);

        CountIndexLevel.countTestResult(testResult);

        if (this.testResultService.createTestResult(testResult)) {
            service.setState(2);
            this.serviceService.updateService(service);

            GroupLevel groupLevel = countGroupLevel(testResult);

            if (this.groupLevelService.createGroupLevel(groupLevel)) {

                service.setState(3);
                this.serviceService.updateService(service);

                SagLevel sagLevel = CountSagLevel.countSagLevel(groupLevel);

                if (this.sagLevelService.createSagLevel(sagLevel)) {
                    service.setState(4);
                    service.setServicelevel(sagLevel.getLevel());
                    this.serviceService.updateService(service);

                    this.issue5Service.accessIssue5ApiAsync("http://192.168.118.146:8098/bjca/service/Task1AndTask2Result", issue2Result.getServiceIDtestID());

                    return ResponseBo.ok("serviceid_testid = " + issue2Result.getServiceIDtestID() + " 的数据新增成功");
                } else {
                    return ResponseBo.fail("serviceId:" + sagLevel.getServiceid() + ",testResult添加成功,groupLevel添加成功,sagLevel添加失败");
                }
            } else {
                return ResponseBo.fail("serviceId:" + groupLevel.getServiceid() + ",testResult添加成功,groupLevel添加失败");
            }

        } else {
            return ResponseBo.fail("serviceId:" + testResult.getServiceid() + ",testResult添加失败");
        }
    }

}

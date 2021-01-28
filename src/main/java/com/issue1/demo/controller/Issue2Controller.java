package com.issue1.demo.controller;

import com.issue1.demo.entity.*;
import com.issue1.demo.service.*;
import com.issue1.demo.util.CountIndexLevel;
import com.issue1.demo.util.CountSagLevel;
import com.issue1.demo.utilEntity.Issue2ResultUtil;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.issue1.demo.util.CountGroupLevel.setGroupLevel;
import static com.issue1.demo.util.Issue2Util.*;

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

    public Issue2Controller(IIssue2ResultService issue2ResultService, IIssue2ResultDetailService iIssue2ResultDetailService, IServiceService serviceService, ITestResultService testResultService, IGroupLevelService groupLevelService, ISagLevelService sagLevelService) {
        this.serviceService = serviceService;
        this.testResultService = testResultService;
        this.groupLevelService = groupLevelService;
        this.sagLevelService = sagLevelService;
        this.issue2ResultService = issue2ResultService;
        this.iIssue2ResultDetailService = iIssue2ResultDetailService;
    }

    @GetMapping({"getAll"})
    public ResponseBo getAllIssue2Results(Issue2Result issue2Result) {
        List<Issue2Result> data = this.issue2ResultService.findIssue2Results(issue2Result);
        if (data != null) {
            if (data.size() != 0)
                System.out.println(data.get(0));
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping({"getAllDetailById"})
    public ResponseBo getAllIssue2ResultDetails(Issue2ResultDetail issue2ResultDetail) {
        List<Issue2ResultDetail> data = this.iIssue2ResultDetailService.findIssue2ResultDetails(issue2ResultDetail);
        if (data != null) {
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @PostMapping({"add"})
    public ResponseBo addService(@Validated @RequestBody Issue2ResultUtil issue2ResultUtil, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError allError : bindingResult.getAllErrors()) {
                stringBuffer.append(allError.getDefaultMessage()).append(";");
            }
            return ResponseBo.fail(stringBuffer.toString());
        }
        Issue2Result issue2Result = utilToEntity(issue2ResultUtil);

        System.out.println(issue2Result);
        System.out.println(issue2Result.getEvaluation_results());


        if (!this.issue2ResultService.createIssue2Result(issue2Result))
            ResponseBo.fail("issue2Result添加失败");

        List<Issue2ResultDetail> list = issue2Result.getEvaluation_results();

        for (Issue2ResultDetail issue2ResultDetail : list) {
            issue2ResultDetail.setIssue2resultid(issue2Result.getIssue2resultid());
        }

        if (!this.iIssue2ResultDetailService.createIssue2ResultDetailBatch(list))
            ResponseBo.fail("issue2ResultDetail添加失败");

        System.out.println(issue2Result);

        Service service = issue2ResultToService(issue2Result);
        if (!this.serviceService.createService(service))
            ResponseBo.fail("service添加失败");

        TestResult testResult = generateIssue2TestResult(service);

        CountIndexLevel.countTestResult(testResult);

        if (this.testResultService.createTestResult(testResult)) {
            System.out.println("serviceId:" + testResult.getServiceid() + ",testResult添加成功");

            service.setState(2);
            this.serviceService.updateService(service);

            GroupLevel groupLevel = setGroupLevel(testResult);

            if (this.groupLevelService.createGroupLevel(groupLevel)) {
                System.out.println("serviceId:" + groupLevel.getServiceid() + ",groupLevel添加成功");
                service.setState(3);
                this.serviceService.updateService(service);

                SagLevel sagLevel = CountSagLevel.setSagLevel(groupLevel);

                if (this.sagLevelService.createSagLevel(sagLevel)) {
                    System.out.println("serviceId:" + sagLevel.getServiceid() + ",sagLevel");

                    service.setState(4);
                    service.setServicelevel(sagLevel.getLevel());
                    this.serviceService.updateService(service);

                    return ResponseBo.ok("全部数据已正确添加");
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

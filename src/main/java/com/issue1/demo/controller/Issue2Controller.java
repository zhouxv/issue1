package com.issue1.demo.controller;

import com.issue1.demo.entity.Issue2Result;
import com.issue1.demo.entity.Issue2ResultDetail;
import com.issue1.demo.entity.Service;
import com.issue1.demo.service.*;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.issue1.demo.util.Issue2Util.issue2ResultToService;

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
    private final IServiceDetailService serviceDetailService;
    private final ITestResultService testResultService;
    private final IGroupLevelService groupLevelService;
    private final ISagLevelService sagLevelService;
    private final IIssue2ResultService issue2ResultService;
    private final IIssue2ResultDetailService iIssue2ResultDetailService;

    public Issue2Controller(IIssue2ResultService issue2ResultService, IIssue2ResultDetailService iIssue2ResultDetailService, IServiceService serviceService, IServiceDetailService serviceDetailService, ITestResultService testResultService, IGroupLevelService groupLevelService, ISagLevelService sagLevelService) {
        this.serviceService = serviceService;
        this.serviceDetailService = serviceDetailService;
        this.testResultService = testResultService;
        this.groupLevelService = groupLevelService;
        this.sagLevelService = sagLevelService;
        this.issue2ResultService = issue2ResultService;
        this.iIssue2ResultDetailService = iIssue2ResultDetailService;
    }

    @PostMapping({"add"})
    public ResponseBo addService(@Validated @RequestBody Issue2Result issue2Result, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError allError : bindingResult.getAllErrors()) {
                stringBuffer.append(allError.getDefaultMessage()).append(";");
            }
            return ResponseBo.fail(stringBuffer.toString());
        }

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


//        CountIndexLevel.countTestResult(testResult);
//        service.setServiceid(testResult.getServiceid());
//
//        if (this.testResultService.createTestResult(testResult)) {
//            System.out.println("serviceId:" + testResult.getServiceid() + ",testResult添加成功");
//
//            service.setState(2);
//            this.serviceService.updateService(service);
//
//            GroupLevel groupLevel = setGroupLevel(testResult);
//
//            if (this.groupLevelService.createGroupLevel(groupLevel)) {
//                System.out.println("serviceId:" + groupLevel.getServiceid() + ",groupLevel添加成功");
//                service.setState(3);
//                this.serviceService.updateService(service);
//
//                SagLevel sagLevel = CountSagLevel.setSagLevel(groupLevel);
//
//                if (this.sagLevelService.createSagLevel(sagLevel)) {
//                    System.out.println("serviceId:" + sagLevel.getServiceid() + ",sagLevel");
//
//                    service.setState(4);
//                    service.setServicelevel(sagLevel.getLevel());
//                    this.serviceService.updateService(service);
//
//                    return ResponseBo.ok("全部数据已正确添加");
//                } else {
//                    return ResponseBo.fail("serviceId:" + sagLevel.getServiceid() + ",testResult添加成功,groupLevel添加成功,sagLevel添加失败");
//                }
//
//            } else {
//                return ResponseBo.fail("serviceId:" + groupLevel.getServiceid() + ",testResult添加成功,groupLevel添加失败");
//            }
//
//        } else {
//            return ResponseBo.fail("serviceId:" + testResult.getServiceid() + ",testResult添加失败");
//        }


        return ResponseBo.ok("添加成功");
    }

}

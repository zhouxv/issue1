package com.issue1.demo.controller;

import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.entity.SagLevel;
import com.issue1.demo.entity.Service;
import com.issue1.demo.entity.TestResult;
import com.issue1.demo.service.IGroupLevelService;
import com.issue1.demo.service.ISagLevelService;
import com.issue1.demo.service.IServiceService;
import com.issue1.demo.service.ITestResultService;
import com.issue1.demo.util.countLevel.CountIndexLevel;
import com.issue1.demo.util.countLevel.CountSagLevel;
import com.issue1.demo.utilEntity.FormatCheckResult;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.issue1.demo.util.FormatCheck.testResultFormatCheck;
import static com.issue1.demo.util.countLevel.CountGroupLevel.countGroupLevel;

/**
 * Controller
 *
 * @author zhouxv
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"testResult"})
public class TestResultController extends BaseController {
    private final IServiceService serviceService;
    private final ITestResultService testResultService;
    private final IGroupLevelService groupLevelService;
    private final ISagLevelService sagLevelService;

    public TestResultController(IServiceService serviceService, ITestResultService testResultService, IGroupLevelService groupLevelService, ISagLevelService sagLevelService) {
        this.serviceService = serviceService;
        this.testResultService = testResultService;
        this.groupLevelService = groupLevelService;
        this.sagLevelService = sagLevelService;
    }

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     * <p>
     * public String testResultIndex(){
     * return "您的templates目录下的视图文件夹名/testResult/testResult";
     * }
     */
    @GetMapping({"getAll"})
    public ResponseBo getAllTestResults(TestResult testResult) {
        List<TestResult> data = testResultService.findTestResults(testResult);
        if (data != null) {
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @PostMapping({"add"})
    public ResponseBo addTestResult(@Valid @RequestBody TestResult testResult) {
        if (testResult.getServiceid() == null) return ResponseBo.fail("serviceid字段不能为空");

        FormatCheckResult result = testResultFormatCheck(testResult);
        if (result.isError()) {
            return ResponseBo.fail(result.getErrorString());
        }

        CountIndexLevel.countTestResult(testResult);
        Service service = new Service();
        service.setServiceid(testResult.getServiceid());

        if (this.testResultService.createTestResult(testResult)) {
            System.out.println("serviceId:" + testResult.getServiceid() + ",testResult添加成功");

            service.setState(2);
            this.serviceService.updateService(service);

            GroupLevel groupLevel = countGroupLevel(testResult);

            if (this.groupLevelService.createGroupLevel(groupLevel)) {
                System.out.println("serviceId:" + groupLevel.getServiceid() + ",groupLevel添加成功");
                service.setState(3);
                this.serviceService.updateService(service);

                SagLevel sagLevel = CountSagLevel.countSagLevel(groupLevel);

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

//    @PostMapping({"test"})
//    public ResponseBo test(@Valid Integer serviceId) {
//        GroupLevel groupLevel=new GroupLevel();
//        groupLevel.setServiceid(serviceId);
//        groupLevel=this.groupLevelService.findGroupLevels(groupLevel).get(0);
//        if (groupLevel != null) {
//            return ResponseBo.ok(setSagLevel(groupLevel));
//        }
//        return ResponseBo.fail();
//    }


    @PostMapping({"update"})
    public ResponseBo updateTestResult(@RequestBody TestResult testResult) {
        if (testResult.getServiceid() == null) return ResponseBo.fail("serviceid字段不能为空");

        FormatCheckResult result = testResultFormatCheck(testResult);
        if (result.isError()) {
            System.out.println(result.getErrorString());
            return ResponseBo.fail(result.getErrorString());
        }

        return this.update(testResult, this.serviceService, this.testResultService, this.groupLevelService, this.sagLevelService);
    }

//    @PostMapping({"updateByServiceId"})
//    public ResponseBo updateTestResultByServiceId(Integer serviceId) {
//        if (serviceId == null) return ResponseBo.fail("serviceid字段不能为空");
//
//        TestResult testResult1 = new TestResult();
//        testResult1.setServiceid(serviceId);
//
//        List<TestResult> testResultList = this.testResultService.findTestResults(testResult1);
//        if (testResultList.isEmpty()) return ResponseBo.ok("没有找到ServiceId为" + testResult1.getServiceid() + "的记录");
//
//        TestResult testResult = testResultList.get(0);
//
//        CountIndexLevel.countTestResult(testResult);
//        GroupLevel groupLevel = setGroupLevel(testResult);
//        SagLevel sagLevel = CountSagLevel.setSagLevel(groupLevel);
//
//        Service service = new Service();
//        service.setServiceid(testResult.getServiceid());
//
//        if (this.testResultService.updateTestResultById(testResult)) {
//            service.setState(2);
//            this.serviceService.updateService(service);
//            System.out.println(groupLevel);
//            if (this.groupLevelService.updateGroupLevelByServiceId(groupLevel)) {
//
//                service.setState(3);
//                this.serviceService.updateService(service);
//
//                if (this.sagLevelService.updateSagLevelByServiceId(sagLevel)) {
//                    service.setState(4);
//                    service.setServicelevel(sagLevel.getLevel());
//                    this.serviceService.updateService(service);
//                    return ResponseBo.ok("全部数据更新完毕");
//                } else {
//                    return ResponseBo.fail("serviceId:" + sagLevel.getServiceid() + ",testResult更新成功,groupLevel更新成功,sagLevel更新失败");
//                }
//            } else {
//                return ResponseBo.fail("serviceId:" + groupLevel.getServiceid() + ",testResult更新成功,groupLevel更新失败");
//            }
//        } else {
//            return ResponseBo.fail("serviceId:" + testResult.getServiceid() + ",testResult更新失败");
//        }
//    }
//
//    @PostMapping({"updateAll"})
//    public List<ResponseBo> updateAllTestResult(TestResult testResult) {
//        List<ResponseBo> list=new ArrayList<>();
//        List<TestResult> testResultList = this.testResultService.findTestResults(testResult);
//        if (testResultList.isEmpty()) {
//            list.add(ResponseBo.ok("没有找到的记录"));
//            return list;
//        }
//
//        for (TestResult result : testResultList) {
//            list.add(this.update(result,this.serviceService,this.testResultService,this.groupLevelService,this.sagLevelService));
//        }
//        return list;
//    }


    public ResponseBo update(TestResult testResult, IServiceService serviceService, ITestResultService testResultService, IGroupLevelService groupLevelService, ISagLevelService sagLevelService) {
        CountIndexLevel.countTestResult(testResult);
        GroupLevel groupLevel = countGroupLevel(testResult);
        SagLevel sagLevel = CountSagLevel.countSagLevel(groupLevel);

        Service service = new Service();
        service.setServiceid(testResult.getServiceid());

        if (testResultService.updateTestResultById(testResult)) {
            service.setState(2);
            serviceService.updateService(service);
            System.out.println(groupLevel);
            if (groupLevelService.updateGroupLevelByServiceId(groupLevel)) {

                service.setState(3);
                serviceService.updateService(service);

                if (sagLevelService.updateSagLevelByServiceId(sagLevel)) {
                    service.setState(4);
                    service.setServicelevel(sagLevel.getLevel());
                    serviceService.updateService(service);
                    return ResponseBo.ok("全部数据更新完毕");
                } else {
                    return ResponseBo.fail("serviceId:" + sagLevel.getServiceid() + ",testResult更新成功,groupLevel更新成功,sagLevel更新失败");
                }
            } else {
                return ResponseBo.fail("serviceId:" + groupLevel.getServiceid() + ",testResult更新成功,groupLevel更新失败");
            }
        } else {
            return ResponseBo.fail("serviceId:" + testResult.getServiceid() + ",testResult更新失败");
        }
    }
}

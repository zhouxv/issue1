package com.issue1.demo.controller;

import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.entity.SagLevel;
import com.issue1.demo.entity.Service;
import com.issue1.demo.service.IGroupLevelService;
import com.issue1.demo.service.ISagLevelService;
import com.issue1.demo.service.IServiceService;
import com.issue1.demo.util.CountIndexLevel;
import com.issue1.demo.util.CountSagLevel;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.dependence.common.entity.ResponseBo;
import com.issue1.demo.entity.TestResult;
import com.issue1.demo.service.ITestResultService;

import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.acl.Group;
import java.util.List;

import static com.issue1.demo.util.CountGroupLevel.setGroupLevel;
import static com.issue1.demo.util.CountSagLevel.setSagLevel;

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

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private ITestResultService testResultService;

    @Autowired
    private IGroupLevelService groupLevelService;

    @Autowired
    private ISagLevelService sagLevelService;

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
        if(testResult.getServiceid()==null) return ResponseBo.fail("serviceid字段不能为空");
        CountIndexLevel.countTestResult(testResult);
        Service service=new Service();
        service.setServiceid(testResult.getServiceid());
        if (this.testResultService.createTestResult(testResult)) {
            System.out.println("serviceId:" + testResult.getServiceid() + ",testResult添加成功");

            service.setState(2);
            this.serviceService.updateService(service);

            GroupLevel groupLevel=setGroupLevel(testResult);

            if (this.groupLevelService.createGroupLevel(groupLevel)) {
                System.out.println("serviceId:" + groupLevel.getServiceid() + ",groupLevel添加成功");
                service.setState(3);
                this.serviceService.updateService(service);

                SagLevel sagLevel= CountSagLevel.setSagLevel(groupLevel);

                if (this.sagLevelService.createSagLevel(sagLevel)) {
                    System.out.println("serviceId:" + sagLevel.getServiceid() + ",sagLevel");

                    service.setState(3);
                    service.setServicelevel(sagLevel.getLevel());
                    this.serviceService.updateService(service);

                    return ResponseBo.ok("全部数据已正确添加");
                }
                else{
                    return ResponseBo.fail("serviceId:" + sagLevel.getServiceid() + ",testResult添加成功,groupLevel添加成功,sagLevel添加失败");
                }

            }
            else {
                return ResponseBo.fail("serviceId:" + groupLevel.getServiceid() + ",testResult添加成功,groupLevel添加失败");
            }


        }
        else {
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
        if (this.testResultService.updateTestResultById(testResult)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }
}

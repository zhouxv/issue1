package com.issue1.demo.controller;

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
import java.util.List;

/**
 * Controller
 *
 * @author zhouxv
 * @date 2020-12-21 14:47:28
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"testResult"})
public class TestResultController extends BaseController {

    @Autowired
    private ITestResultService testResultService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
     * @GetMapping("您的templates目录下的视图文件夹名" + "testResult")
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

    @GetMapping({"getAllPage"})
    public ResponseBo testResultList(QueryRequest request, TestResult testResult) {
        IPage<TestResult> data = this.testResultService.findTestResults(request, testResult);
        if (data != null) {
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping({"add"})
    public ResponseBo addTestResult(@Valid TestResult testResult) {
        if (this.testResultService.createTestResult(testResult)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }


    @DeleteMapping({"delete"})
    public ResponseBo deleteTestResult(TestResult testResult) {
        if (this.testResultService.deleteTestResult(testResult)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

    @PostMapping({"update"})
    public ResponseBo updateTestResult(TestResult testResult) {
        if (this.testResultService.updateTestResult(testResult)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

}

package com.issue1.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.issue1.demo.entity.TestResult;
import com.issue1.dependence.common.entity.QueryRequest;

import java.util.List;

/**
 *  Service接口
 *
 * @author zhouxv
 */
public interface ITestResultService extends IService<TestResult> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param testResult testResult
     * @return IPage<TestResult>
     */
    IPage<TestResult> findTestResults(QueryRequest request, TestResult testResult);


    /**
     * 查询（所有）
     *
     * @param testResult testResult
     * @return List<TestResult>
     */
    List<TestResult> findTestResults(TestResult testResult);

    TestResult findOneTestResultByServiceId(Integer serviceId);

    /**
     * 新增
     *
     * @param testResult testResult
     */
    Boolean createTestResult(TestResult testResult);

    /**
     * 修改
     *
     * @param testResult testResult
     */
    Boolean updateTestResult(TestResult testResult);

    Boolean updateTestResultById(TestResult testResult);
    /**
     * 删除
     *
     * @param testResult testResult
     */
    Boolean deleteTestResult(TestResult testResult);

    /**
     * 根据ServiceId删除
     *
     * @param integer integer
     */
    Boolean deleteTestResultById(Integer integer);
}

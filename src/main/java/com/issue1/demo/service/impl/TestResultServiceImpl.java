package com.issue1.demo.service.impl;

import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.demo.entity.TestResult;
import com.issue1.demo.mapper.TestResultMapper;
import com.issue1.demo.service.ITestResultService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 *  Service实现
 *
 * @author zhouxv
 * @date 2020-12-21 14:47:28
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TestResultServiceImpl extends ServiceImpl<TestResultMapper, TestResult> implements ITestResultService {

    private final TestResultMapper testResultMapper;

    @Override
    public IPage<TestResult> findTestResults(QueryRequest request, TestResult testResult) {
        LambdaQueryWrapper<TestResult> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<TestResult> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<TestResult> findTestResults(TestResult testResult) {
	    LambdaQueryWrapper<TestResult> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createTestResult(TestResult testResult) {
        return this.save(testResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateTestResult(TestResult testResult) {
        return this.saveOrUpdate(testResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteTestResult(TestResult testResult) {
        LambdaQueryWrapper<TestResult> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}

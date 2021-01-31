package com.issue1.demo.service.entityServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.issue1.demo.entity.TestResult;
import com.issue1.demo.mapper.TestResultMapper;
import com.issue1.demo.service.entityService.ITestResultService;
import com.issue1.dependence.common.entity.QueryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  Service实现
 *
 * @author zhouxv
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
        //按servieceId索引
        if (testResult.getServiceid() != null) queryWrapper.eq(TestResult::getServiceid, testResult.getServiceid());
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public TestResult findOneTestResultByServiceId(Integer serviceId) {
        LambdaQueryWrapper<TestResult> queryWrapper = new LambdaQueryWrapper<>();
        //按servieceId索引
        queryWrapper.eq(TestResult::getServiceid, serviceId);
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createTestResult(TestResult testResult) {
        testResult.setDeletestate(1);
        return this.save(testResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateTestResult(TestResult testResult) {
        return this.saveOrUpdate(testResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateTestResultById(TestResult testResult) {
        return this.updateById(testResult);
    }

    @Override
    public Boolean deleteTestResultById(Integer integer) {
        TestResult testResult=new TestResult();
        testResult.setDeletestate(0);

        LambdaUpdateWrapper<TestResult> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(TestResult::getServiceid,integer);

        return this.update(testResult,wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteTestResult(TestResult testResult) {
        LambdaQueryWrapper<TestResult> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}

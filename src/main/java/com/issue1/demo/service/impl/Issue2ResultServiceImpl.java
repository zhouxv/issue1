package com.issue1.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.issue1.demo.entity.Issue2Result;
import com.issue1.demo.mapper.Issue2ResultMapper;
import com.issue1.demo.service.IIssue2ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service实现
 *
 * @author zhouxv
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Issue2ResultServiceImpl extends ServiceImpl<Issue2ResultMapper, Issue2Result> implements IIssue2ResultService {

    private final Issue2ResultMapper issue2ResultMapper;

    @Override
    public List<Issue2Result> findIssue2Results(Issue2Result issue2Result) {
        LambdaQueryWrapper<Issue2Result> queryWrapper = new LambdaQueryWrapper<>();
        //按indexId索引
        if (issue2Result.getIssue2resultid() != null)
            queryWrapper.eq(Issue2Result::getIssue2resultid, issue2Result.getIssue2resultid());
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean createIssue2Result(Issue2Result issue2Result) {
        return this.save(issue2Result);
    }

    @Override
    public Boolean updateIssue2Result(Issue2Result issue2Result) {
        return this.saveOrUpdate(issue2Result);
    }

    @Override
    public Boolean deleteIssue2Result(Issue2Result issue2Result) {
        LambdaQueryWrapper<Issue2Result> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        return this.remove(wrapper);
    }
}

package com.issue1.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.issue1.demo.entity.Issue2ResultDetail;
import com.issue1.demo.mapper.Issue2ResultDetailMapper;
import com.issue1.demo.service.IIssue2ResultDetailService;
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
public class Issue2ResultServiceDetailImpl extends ServiceImpl<Issue2ResultDetailMapper, Issue2ResultDetail> implements IIssue2ResultDetailService {

    private final Issue2ResultDetailMapper issue2ResultDetailMapper;

    @Override
    public List<Issue2ResultDetail> findIssue2ResultDetails(Issue2ResultDetail issue2ResultDetail) {
        LambdaQueryWrapper<Issue2ResultDetail> queryWrapper = new LambdaQueryWrapper<>();
        //按indexId索引
        if (issue2ResultDetail.getIssue2resultid() != null)
            queryWrapper.eq(Issue2ResultDetail::getIssue2resultid, issue2ResultDetail.getIssue2resultid());
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean createIssue2ResultDetail(Issue2ResultDetail issue2ResultDetail) {
        return this.save(issue2ResultDetail);
    }

    @Override
    public Boolean createIssue2ResultDetailBatch(List<Issue2ResultDetail> issue2ResultDetailList) {
        return this.saveBatch(issue2ResultDetailList);
    }

    @Override
    public Boolean updateIssue2ResultDetail(Issue2ResultDetail issue2ResultDetail) {
        return this.saveOrUpdate(issue2ResultDetail);
    }

    @Override
    public Boolean deleteIssue2ResultDetail(Issue2ResultDetail issue2ResultDetail) {
        LambdaQueryWrapper<Issue2ResultDetail> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        return this.remove(wrapper);
    }
}

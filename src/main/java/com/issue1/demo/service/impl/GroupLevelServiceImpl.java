package com.issue1.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.issue1.demo.entity.SagLevel;
import com.issue1.demo.entity.ServiceDetail;
import com.issue1.demo.entity.TestResult;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.mapper.GroupLevelMapper;
import com.issue1.demo.service.IGroupLevelService;

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
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GroupLevelServiceImpl extends ServiceImpl<GroupLevelMapper, GroupLevel> implements IGroupLevelService {

    private final GroupLevelMapper groupLevelMapper;

    @Override
    public IPage<GroupLevel> findGroupLevels(QueryRequest request, GroupLevel groupLevel) {
        LambdaQueryWrapper<GroupLevel> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<GroupLevel> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<GroupLevel> findGroupLevels(GroupLevel groupLevel) {
	    LambdaQueryWrapper<GroupLevel> queryWrapper = new LambdaQueryWrapper<>();
        //按servieceId索引
        if(groupLevel.getServiceid()!=null) queryWrapper.eq(GroupLevel::getServiceid,groupLevel.getServiceid());
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createGroupLevel(GroupLevel groupLevel) {
        groupLevel.setDeletestate(1);
        return this.save(groupLevel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateGroupLevel(GroupLevel groupLevel) {
        return this.saveOrUpdate(groupLevel);
    }

    @Override
    public Boolean deleteGroupLevelById(Integer integer) {
        GroupLevel groupLevel=new GroupLevel();
        groupLevel.setDeletestate(0);

        LambdaUpdateWrapper<GroupLevel> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(GroupLevel::getServiceid,integer);

        return this.update(groupLevel,wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteGroupLevel(GroupLevel groupLevel) {
        LambdaQueryWrapper<GroupLevel> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}

package com.issue1.demo.service.impl;

import com.issue1.demo.entity.Index;
import com.issue1.demo.mapper.IndexMapper;
import com.issue1.demo.service.IIndexService;
import com.issue1.dependence.common.entity.QueryRequest;


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
public class IIndexServiceImpl extends ServiceImpl<IndexMapper, Index> implements IIndexService {

    private final IndexMapper groupLevelMapper;

    @Override
    public IPage<Index> findIndexs(QueryRequest request, Index index) {
        LambdaQueryWrapper<Index> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Index> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Index> findIndexs(Index index) {
        LambdaQueryWrapper<Index> queryWrapper = new LambdaQueryWrapper<>();
        //按indexId索引
        if(index.getIndexid()!=null) queryWrapper.eq(Index::getIndexid,index.getIndexid());
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createIndex(Index index) {
        return this.save(index);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateIndex(Index index) {
        return this.saveOrUpdate(index);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteIndex(Index index) {
        LambdaQueryWrapper<Index> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        return this.remove(wrapper);
    }
}

package com.issue1.demo.service.impl;

import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.demo.entity.Service;
import com.issue1.demo.mapper.ServiceMapper;
import com.issue1.demo.service.IServiceService;

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
@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, Service> implements IServiceService {

    private final ServiceMapper serviceMapper;

    @Override
    public IPage<Service> findServices(QueryRequest request, Service service) {
        LambdaQueryWrapper<Service> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Service> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Service> findServices(Service service) {
	    LambdaQueryWrapper<Service> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createService(Service service) {
        return this.save(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateService(Service service) {
        return this.saveOrUpdate(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteService(Service service) {
        LambdaQueryWrapper<Service> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}
package com.issue1.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.demo.entity.ServiceDetail;
import com.issue1.demo.mapper.ServiceDetailMapper;
import com.issue1.demo.service.IServiceDetailService;

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
public class ServiceDetailServiceImpl extends ServiceImpl<ServiceDetailMapper, ServiceDetail> implements IServiceDetailService {

    private final ServiceDetailMapper serviceDetailMapper;

    @Override
    public IPage<ServiceDetail> findServiceDetails(QueryRequest request, ServiceDetail serviceDetail) {
        LambdaQueryWrapper<ServiceDetail> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ServiceDetail> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ServiceDetail> findServiceDetails(ServiceDetail serviceDetail) {
	    LambdaQueryWrapper<ServiceDetail> queryWrapper = new LambdaQueryWrapper<>();
        //按servieceId索引
        if(serviceDetail.getServiceid()!=null) queryWrapper.eq(ServiceDetail::getServiceid,serviceDetail.getServiceid());
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createServiceDetail(ServiceDetail serviceDetail) {
        return this.save(serviceDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateServiceDetail(ServiceDetail serviceDetail) {
        return this.saveOrUpdate(serviceDetail);
    }

    @Override
    public Boolean deleteServiceDetailById(Integer integer) {
        ServiceDetail serviceDetail=new ServiceDetail();
        serviceDetail.setDeletestate(0);

        LambdaUpdateWrapper<ServiceDetail> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ServiceDetail::getServiceid,integer);

        return this.update(serviceDetail,wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteServiceDetail(ServiceDetail serviceDetail) {
        LambdaQueryWrapper<ServiceDetail> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    return this.remove(wrapper);
	}
}

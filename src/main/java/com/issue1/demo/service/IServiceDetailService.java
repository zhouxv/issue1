package com.issue1.demo.service;

import com.issue1.demo.entity.ServiceDetail;
import com.issue1.dependence.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author zhouxv
 * @date 2020-12-21 14:47:28
 */
public interface IServiceDetailService extends IService<ServiceDetail> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param serviceDetail serviceDetail
     * @return IPage<ServiceDetail>
     */
    IPage<ServiceDetail> findServiceDetails(QueryRequest request, ServiceDetail serviceDetail);

    /**
     * 查询（所有）
     *
     * @param serviceDetail serviceDetail
     * @return List<ServiceDetail>
     */
    List<ServiceDetail> findServiceDetails(ServiceDetail serviceDetail);

    /**
     * 新增
     *
     * @param serviceDetail serviceDetail
     */
    Boolean createServiceDetail(ServiceDetail serviceDetail);

    /**
     * 修改
     *
     * @param serviceDetail serviceDetail
     */
    Boolean updateServiceDetail(ServiceDetail serviceDetail);

    /**
     * 删除
     *
     * @param serviceDetail serviceDetail
     */
    Boolean deleteServiceDetail(ServiceDetail serviceDetail);
}

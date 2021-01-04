package com.issue1.demo.service;

import com.issue1.demo.entity.Service;
import com.issue1.dependence.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author zhouxv
 */
public interface IServiceService extends IService<Service> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param service service
     * @return IPage<Service>
     */
    IPage<Service> findServices(QueryRequest request, Service service);

    /**
     * 查询（所有）
     *
     * @param service service
     * @return List<Service>
     */
    List<Service> findServices(Service service);

    /**
     * 新增
     *
     * @param service service
     */
    Boolean createService(Service service);

    /**
     * 修改
     *
     * @param service service
     */
    Boolean updateService(Service service);

    /**
     * 删除
     *
     * @param service service
     */
    Boolean deleteService(Service service);

    /**
     * 根据ServiceId删除
     *
     * @param integer integer
     */
    Boolean deleteServiceById(Integer integer);
}

package com.issue1.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.issue1.demo.entity.SagLevel;
import com.issue1.dependence.common.entity.QueryRequest;

import java.util.List;

/**
 *  Service接口
 *
 * @author zhouxv
 */
public interface ISagLevelService extends IService<SagLevel> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param sagLevel sagLevel
     * @return IPage<SagLevel>
     */
    IPage<SagLevel> findSagLevels(QueryRequest request, SagLevel sagLevel);

    /**
     * 查询（所有）
     *
     * @param sagLevel sagLevel
     * @return List<SagLevel>
     */
    List<SagLevel> findSagLevels(SagLevel sagLevel);

    /**
     * 新增
     *
     * @param sagLevel sagLevel
     */
    Boolean createSagLevel(SagLevel sagLevel);

    /**
     修改

     @param sagLevel sagLevel
     */
    Boolean updateSagLevel(SagLevel sagLevel);

    Boolean updateSagLevelByServiceId(SagLevel sagLevel);

    /**
     删除

     @param sagLevel sagLevel
     */
    Boolean deleteSagLevel(SagLevel sagLevel);

    /**
     * 根据ServiceId删除
     *
     * @param integer integer
     */
    Boolean deleteSagLevelById(Integer integer);
}

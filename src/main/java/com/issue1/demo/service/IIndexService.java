package com.issue1.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.issue1.demo.entity.Index;
import com.issue1.dependence.common.entity.QueryRequest;

import java.util.List;

/**
 *  Index接口
 *
 * @author zhouxv
 * @date 2020-12-21 14:47:28
 */
public interface IIndexService extends IService<Index> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param index index
     * @return IPage<GroupLevel>
     */
    IPage<Index> findIndexs(QueryRequest request, Index index);

    /**
     * 查询（所有）
     *
     * @param index index
     * @return List<GroupLevel>
     */
    List<Index> findIndexs(Index index);

    /**
     * 新增
     *
     * @param index index
     */
    Boolean createIndex(Index index);

    /**
     * 修改
     *
     * @param index index
     */
    Boolean updateIndex(Index index);

    /**
     * 删除
     *
     * @param index index
     */
    Boolean deleteIndex(Index index);
}

package com.issue1.demo.service;

import com.issue1.demo.entity.GroupLevel;
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
public interface IGroupLevelService extends IService<GroupLevel> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param groupLevel groupLevel
     * @return IPage<GroupLevel>
     */
    IPage<GroupLevel> findGroupLevels(QueryRequest request, GroupLevel groupLevel);

    /**
     * 查询（所有）
     *
     * @param groupLevel groupLevel
     * @return List<GroupLevel>
     */
    List<GroupLevel> findGroupLevels(GroupLevel groupLevel);

    /**
     * 新增
     *
     * @param groupLevel groupLevel
     */
    Boolean createGroupLevel(GroupLevel groupLevel);

    /**
     * 修改
     *
     * @param groupLevel groupLevel
     */
    Boolean updateGroupLevel(GroupLevel groupLevel);

    /**
     * 删除
     *
     * @param groupLevel groupLevel
     */
    Boolean deleteGroupLevel(GroupLevel groupLevel);
}

package com.issue1.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.issue1.demo.entity.GroupLevel;
import com.issue1.dependence.common.entity.QueryRequest;

import java.util.List;

/**
 *  Service接口
 *
 * @author zhouxv
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

    GroupLevel findOneGroupLevel(Integer serviceId);

    /**
     * 新增
     *
     * @param groupLevel groupLevel
     */
    Boolean createGroupLevel(GroupLevel groupLevel);

    /**
     修改

     @param groupLevel groupLevel
     */
    Boolean updateGroupLevel(GroupLevel groupLevel);

    Boolean updateGroupLevelByServiceId(GroupLevel groupLevel);

    /**
     删除

     @param groupLevel groupLevel
     */
    Boolean deleteGroupLevel(GroupLevel groupLevel);

    /**
     * 根据ServiceId删除
     *
     * @param integer integer
     */
    Boolean deleteGroupLevelById(Integer integer);
}

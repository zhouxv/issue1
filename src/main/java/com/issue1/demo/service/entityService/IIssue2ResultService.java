package com.issue1.demo.service.entityService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.issue1.demo.entity.Issue2Result;

import java.util.List;

/**
 * Index接口
 *
 * @author zhouxv
 */
public interface IIssue2ResultService extends IService<Issue2Result> {
    /**
     * 查询（所有）
     *
     * @return List<GroupLevel>
     */
    List<Issue2Result> findIssue2Results();

    List<Issue2Result> findIssue2ResultsBySTId(Issue2Result issue2Result);

    /*
    根据 id或者serviceId_testId或者二者同时
     */
    Issue2Result findOneIssue2Result(Issue2Result issue2Result);

    /**
     * 新增
     *
     * @param issue2Result Issue2Result
     */
    Boolean createIssue2Result(Issue2Result issue2Result);

    /**
     * 修改
     *
     * @param issue2Result Issue2Result
     */
    Boolean updateIssue2Result(Issue2Result issue2Result);

    /**
     * 删除
     *
     * @param issue2Result issue2Result
     */
    Boolean deleteIssue2Result(Issue2Result issue2Result);
}

package com.issue1.demo.service.entityService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.issue1.demo.entity.Issue2ResultDetail;

import java.util.List;

/**
 * Index接口
 *
 * @author zhouxv
 */
public interface IIssue2ResultDetailService extends IService<Issue2ResultDetail> {

    /**
     * 查询（所有）
     *
     * @return List<GroupLevel>
     */
    List<Issue2ResultDetail> findIssue2ResultDetails();

    /**
     * 查询（所有)符合条件的
     * 根据id，serviceIdTestId，grade三个字段
     *
     * @param issue2ResultDetail issue2ResultDetail
     * @return List<GroupLevel>
     */
    List<Issue2ResultDetail> findIssue2ResultDetails(Issue2ResultDetail issue2ResultDetail);

    List<Issue2ResultDetail> findIssue2ResultDetails(String serviceid_testid, Integer grade);

    /**
     * 新增
     *
     * @param issue2ResultDetail issue2ResultDetail
     */
    Boolean createIssue2ResultDetail(Issue2ResultDetail issue2ResultDetail);

    /**
     * 批量新增
     *
     * @param issue2ResultDetailList List<Issue2ResultDetail>
     */
    Boolean createIssue2ResultDetailBatch(List<Issue2ResultDetail> issue2ResultDetailList);

    /**
     * 修改
     *
     * @param issue2ResultDetail issue2ResultDetail
     */
    Boolean updateIssue2ResultDetail(Issue2ResultDetail issue2ResultDetail);

    /**
     * 删除
     *
     * @param issue2ResultDetail issue2ResultDetail
     */
    Boolean deleteIssue2ResultDetail(Issue2ResultDetail issue2ResultDetail);
}

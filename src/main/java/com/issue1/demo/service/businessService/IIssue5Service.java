package com.issue1.demo.service.businessService;

import com.issue1.demo.utilEntity.issue5ResultUtil.Issue5ResultUtil;

public interface IIssue5Service {
    Issue5ResultUtil geneOneIssue5ResultUtil(String serviceId_testId);

    void accessIssue5ApiAsync(String url, String serviceId_testId);

    Object accessIssue5ApiSync(String url, String serviceId_testId);
}

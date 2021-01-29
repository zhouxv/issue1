package com.issue1.demo.service;

import com.issue1.demo.entity.Issue2Result;
import com.issue1.demo.utilEntity.Issue5ResultUtil;

import java.util.List;

public interface IIssue5ObjectService {
    List<Issue5ResultUtil> geneIssue5ResultUtils(Issue2Result issue2Result);
}

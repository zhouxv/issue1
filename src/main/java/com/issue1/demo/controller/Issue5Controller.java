package com.issue1.demo.controller;

import com.issue1.demo.entity.Issue2Result;
import com.issue1.demo.service.IIssue5ObjectService;
import com.issue1.demo.service.IRemoteAccess;
import com.issue1.demo.utilEntity.issue5ResultUtil.Issue5ResultUtil;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
@Note：

@User：NineSun
@Time:2021/1/28   23:42
*/
@Slf4j
@Validated
@RestController
@RequestMapping({"issue5"})
public class Issue5Controller extends BaseController {

    private final IRemoteAccess remoteAccess;
    private final IIssue5ObjectService issue5ObjectService;

    public Issue5Controller(IRemoteAccess remoteAccess, IIssue5ObjectService issue5ObjectService) {
        this.remoteAccess = remoteAccess;
        this.issue5ObjectService = issue5ObjectService;
    }

    @GetMapping({"getAll"})
    public ResponseBo getAll() {
        return ResponseBo.ok(this.issue5ObjectService.geneIssue5ResultUtils(null));
    }

    @GetMapping({"getOneBySTId"})
    public Issue5ResultUtil getOneBySTId(String serviceId_testId) {
        Issue2Result issue2Result = new Issue2Result();
        issue2Result.setServiceIDtestID(serviceId_testId);
        List<Issue5ResultUtil> list = this.issue5ObjectService.geneIssue5ResultUtils(issue2Result);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @GetMapping({"submitAll"})
    public ResponseBo submitAll() {
//        Index index=new Index();
//        index.setIndexid(2);
//        Object data=this.remoteAccess.getJson("http://120.78.139.61:10080/issue1/index/getAll?indexid={indexid}",index.getIndexid());

        Object data = this.remoteAccess.postJson("http://192.168.118.146:8098/bjca/service/Task1AndTask2Result", this.issue5ObjectService.geneIssue5ResultUtils(null));
        return ResponseBo.ok(data);
    }

    @GetMapping({"submitOneBySTId"})
    public ResponseBo submitOne(String serviceId_testId) {
        Issue2Result issue2Result = new Issue2Result();
        Object data;

        issue2Result.setServiceIDtestID(serviceId_testId);
        List<Issue5ResultUtil> list = this.issue5ObjectService.geneIssue5ResultUtils(issue2Result);

        if (!list.isEmpty())
            data = this.remoteAccess.postJson("http://192.168.118.146:8098/bjca/service/Task1AndTask2Result", list.get(0));
        else
            data = this.remoteAccess.postJson("http://192.168.118.146:8098/bjca/service/Task1AndTask2Result", null);
        return ResponseBo.ok(data);
    }
}

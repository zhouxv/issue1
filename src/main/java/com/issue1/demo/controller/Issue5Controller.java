package com.issue1.demo.controller;

import com.issue1.demo.service.businessService.IIssue5Service;
import com.issue1.demo.service.businessService.IRemoteAccess;
import com.issue1.demo.service.entityService.IIssue2ResultService;
import com.issue1.demo.utilEntity.issue5ResultUtil.Issue5ResultUtil;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private final IIssue5Service issue5ObjectService;

    public Issue5Controller(IRemoteAccess remoteAccess, IIssue5Service issue5ObjectService, IIssue2ResultService issue2ResultService) {
        this.remoteAccess = remoteAccess;
        this.issue5ObjectService = issue5ObjectService;
    }

    @GetMapping({"getOneBy"})
    public Issue5ResultUtil getOneBy(String serviceId_testId) {
        return this.issue5ObjectService.geneOneIssue5ResultUtil(serviceId_testId);
    }


//        Index index=new Index();
//        index.setIndexid(2);
//        Object data=this.remoteAccess.getJson("http://120.78.139.61:10080/issue1/index/getAll?indexid={indexid}",index.getIndexid());

//        Object data = this.remoteAccess.postJson("http://192.168.118.146:8098/bjca/service/Task1AndTask2Result", this.issue5ObjectService.geneIssue5ResultUtils(null));
//        return ResponseBo.ok(data);

    @GetMapping({"submitOneBy"})
    public ResponseBo submitOne(String serviceId_testId) {
        Object data;
        data = this.issue5ObjectService.accessIssue5ApiSync("http://192.168.118.146:8098/bjca/service/Task1AndTask2Result", serviceId_testId);
        return ResponseBo.ok(data);
    }
}

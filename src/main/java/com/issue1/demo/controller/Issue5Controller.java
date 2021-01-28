package com.issue1.demo.controller;

import com.issue1.demo.service.*;
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
    private final IServiceService serviceService;
    private final ITestResultService testResultService;
    private final IGroupLevelService groupLevelService;
    private final ISagLevelService sagLevelService;
    private final IIssue2ResultService issue2ResultService;
    private final IIssue2ResultDetailService iIssue2ResultDetailService;
    private final IRemoteAccess remoteAccess;

    public Issue5Controller(IIssue2ResultService issue2ResultService, IIssue2ResultDetailService iIssue2ResultDetailService, IServiceService serviceService, ITestResultService testResultService, IGroupLevelService groupLevelService, ISagLevelService sagLevelService, IRemoteAccess remoteAccess) {
        this.serviceService = serviceService;
        this.testResultService = testResultService;
        this.groupLevelService = groupLevelService;
        this.sagLevelService = sagLevelService;
        this.issue2ResultService = issue2ResultService;
        this.iIssue2ResultDetailService = iIssue2ResultDetailService;
        this.remoteAccess = remoteAccess;
    }

    @GetMapping({"getAll"})
    public ResponseBo getAll() {
//        Index index=new Index();
//        index.setIndexid(2);
//        Object data=this.remoteAccess.getJson("http://120.78.139.61:10080/issue1/index/getAll?indexid={indexid}",index.getIndexid());
//        Service service = new Service();
//        service.setServicename("ASdasda");
//        service.setServicecompany("ASdasda");
//        service.setServicetype("数据服务");
//        service.setTestorganization("asdasd");
//        Object data = this.remoteAccess.postJson("http://120.78.139.61:10080/issue1/service/add", service);
//        return ResponseBo.ok(data);


        return null;
    }

}

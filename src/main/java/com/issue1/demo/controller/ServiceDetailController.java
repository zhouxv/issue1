package com.issue1.demo.controller;

import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.dependence.common.entity.ResponseBo;
import com.issue1.demo.entity.ServiceDetail;
import com.issue1.demo.service.IServiceDetailService;

import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller
 *
 * @author zhouxv
 * @date 2020-12-21 14:47:28
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"serviceDetail"})
public class ServiceDetailController extends BaseController {

    @Autowired
    private IServiceDetailService serviceDetailService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
     * @GetMapping("您的templates目录下的视图文件夹名" + "serviceDetail")
     * public String serviceDetailIndex(){
     * return "您的templates目录下的视图文件夹名/serviceDetail/serviceDetail";
     * }
     */
    @GetMapping({"getAll"})
    public ResponseBo getAllServiceDetails(ServiceDetail serviceDetail) {
        List<ServiceDetail> data = serviceDetailService.findServiceDetails(serviceDetail);
        if (data != null) {
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping({"getAllPage"})
    public ResponseBo getAllServiceDetailsPage(QueryRequest request, ServiceDetail serviceDetail) {
        IPage<ServiceDetail> data = this.serviceDetailService.findServiceDetails(request, serviceDetail);
        if (data != null) {
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping({"add"})
    public ResponseBo addServiceDetail(@Valid ServiceDetail serviceDetail) {
        if (this.serviceDetailService.createServiceDetail(serviceDetail)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }


    @DeleteMapping({"delete"})
    public ResponseBo deleteServiceDetail(ServiceDetail serviceDetail) {
        if (this.serviceDetailService.deleteServiceDetail(serviceDetail)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

    @PostMapping({"update"})
    public ResponseBo updateServiceDetail(ServiceDetail serviceDetail) {
        if (this.serviceDetailService.updateServiceDetail(serviceDetail)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

}

package com.issue1.demo.controller;

import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.dependence.common.entity.ResponseBo;
import com.issue1.demo.entity.Service;
import com.issue1.demo.service.IServiceService;

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
@RequestMapping({"service"})
public class ServiceController extends BaseController {

    @Autowired
    private IServiceService serviceService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
     * @GetMapping("您的templates目录下的视图文件夹名" + "service")
     * public String serviceIndex(){
     * return "您的templates目录下的视图文件夹名/service/service";
     * }
     */
    @GetMapping({"getAll"})
    public ResponseBo getAllServices(Service service) {
        List<Service> data = serviceService.findServices(service);
        if (data != null) {
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping({"getAllPage"})
    public ResponseBo getAllServicesPage(QueryRequest request, Service service) {
        IPage<Service> data = this.serviceService.findServices(request, service);
        if (data != null) {
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping({"add"})
    public ResponseBo addService(@Valid Service service) {
        if (this.serviceService.createService(service)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }


    @DeleteMapping({"delete"})
    public ResponseBo deleteService(Service service) {
        if (this.serviceService.deleteService(service)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

    @PostMapping({"update"})
    public ResponseBo updateService(Service service) {
        if (this.serviceService.updateService(service)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

}

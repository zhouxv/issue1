package com.issue1.demo.controller;

import com.issue1.demo.entity.ServiceDetail;
import com.issue1.demo.service.*;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.dependence.common.entity.ResponseBo;
import com.issue1.demo.entity.Service;

import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author zhouxv
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"service"})
public class ServiceController extends BaseController {

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceDetailService serviceDetailService;

    @Autowired
    private ITestResultService testResultService;

    @Autowired
    private IGroupLevelService groupLevelService;

    @Autowired
    private ISagLevelService sagLevelService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     * <p>
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

//    @GetMapping({"getAllPage"})
//    public ResponseBo getAllServicesPage(QueryRequest request, Service service) {
//        IPage<Service> data = this.serviceService.findServices(request, service);
//        if (data != null) {
//            return ResponseBo.ok(getDataTable(data));
//        }
//        return ResponseBo.fail();
//    }


    @PostMapping({"add"})
    public ResponseBo addService(@Valid @RequestBody Service service) {
        System.out.println(service.getServicename());
        if (this.serviceService.createService(service)) {
            Map<String,Integer> map=new HashMap<>();
            map.put("serviceid",service.getServiceid());
            return ResponseBo.ok(map);
        } else {
            return ResponseBo.fail();
        }
    }


    @DeleteMapping({"delete"})
    public ResponseBo deleteService(Service service) {
        if (service.getServiceid() == null) return ResponseBo.fail("该删除为单个entity删除,请传入serviceid");
        Integer serviceId = service.getServiceid();

        if (serviceService.deleteServiceById(serviceId)) {
            System.out.println("Service deleteState=0 操作成功");
        }else{
            ResponseBo.fail("Service deleteState=0 操作失败");
        }

        if (serviceDetailService.deleteServiceDetailById(serviceId)) {
            System.out.println("ServiceDetailService deleteState=0 操作成功");
        }else{
            ResponseBo.fail("ServiceDetailService deleteState=0 操作失败");
        }

        if (testResultService.deleteTestResultById(serviceId)) {
            System.out.println("TestResultService deleteState=0 操作成功");
        }else{
            ResponseBo.fail("TestResultService deleteState=0 操作失败");
        }

        if (groupLevelService.deleteGroupLevelById(serviceId)) {
            System.out.println("GroupLevelService deleteState=0 操作成功");
        }else{
            ResponseBo.fail("GroupLevelService deleteState=0 操作失败");
        }

        if (sagLevelService.deleteSagLevelById(serviceId)) {
            System.out.println("SagLevelService deleteState=0 操作成功");
        }else{
            ResponseBo.fail("SagLevelService deleteState=0 操作失败");
        }
        return ResponseBo.ok();
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

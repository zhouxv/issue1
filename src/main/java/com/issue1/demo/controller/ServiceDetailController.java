package com.issue1.demo.controller;

import com.issue1.demo.entity.ServiceDetail;
import com.issue1.demo.service.entityService.IServiceDetailService;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller
 *
 * @author zhouxv
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"serviceDetail"})
public class ServiceDetailController extends BaseController {

    private final IServiceDetailService serviceDetailService;

    public ServiceDetailController(IServiceDetailService serviceDetailService) {
        this.serviceDetailService = serviceDetailService;
    }


    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     * <p>
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


    @PostMapping({"add"})
    public ResponseBo addServiceDetail(@Valid @RequestBody ServiceDetail serviceDetail, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError allError : bindingResult.getAllErrors()) {
                stringBuffer.append(allError.getDefaultMessage()).append(";");
            }
            return ResponseBo.fail(stringBuffer.toString());
        }


        if (this.serviceDetailService.createServiceDetail(serviceDetail)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

//    @PostMapping({"update"})
//    public ResponseBo updateServiceDetail(ServiceDetail serviceDetail) {
//        if (this.serviceDetailService.updateServiceDetail(serviceDetail)) {
//            return ResponseBo.ok();
//        } else {
//            return ResponseBo.fail();
//        }
//    }

}

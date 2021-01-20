package com.issue1.demo.controller;

import com.issue1.demo.entity.SagLevel;
import com.issue1.demo.service.ISagLevelService;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.issue1.demo.util.DTO.DtoListSagLevel;

/**
 * Controller
 *
 * @author zhouxv
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"sagLevel"})
public class SagLevelController extends BaseController {

    @Autowired
    private ISagLevelService sagLevelService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
     * public String sagLevelIndex(){
     * return "您的templates目录下的视图文件夹名/sagLevel/sagLevel";
     * }
     */
    @GetMapping({"getAllDto"})
    public ResponseBo getAllSagLevelsDto(SagLevel sagLevel) {
        List<SagLevel> data = sagLevelService.findSagLevels(sagLevel);
        List<Map<String,Object>> mapList= DtoListSagLevel(data);
        if (mapList != null) {
            return ResponseBo.ok(mapList);
        }
        return ResponseBo.fail();
    }

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
     * public String sagLevelIndex(){
     * return "您的templates目录下的视图文件夹名/sagLevel/sagLevel";
     * }
     */
    @GetMapping({"getAll"})
    public ResponseBo getAllSagLevels(SagLevel sagLevel) {
        List<SagLevel> data = sagLevelService.findSagLevels(sagLevel);
        if (data != null) {
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @PostMapping({"update"})
    public ResponseBo updateSagLevelByServiceId(@RequestBody SagLevel sagLevel) {
        if (this.sagLevelService.updateSagLevelByServiceId(sagLevel)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

}

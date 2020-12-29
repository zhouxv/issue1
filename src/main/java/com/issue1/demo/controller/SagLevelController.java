package com.issue1.demo.controller;

import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.dependence.common.entity.ResponseBo;
import com.issue1.demo.entity.SagLevel;
import com.issue1.demo.service.ISagLevelService;

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
@RequestMapping({"sagLevel"})
public class SagLevelController extends BaseController {

    @Autowired
    private ISagLevelService sagLevelService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
     * @GetMapping("您的templates目录下的视图文件夹名" + "sagLevel")
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

    @GetMapping({"getAllPage"})
    public ResponseBo getAllSagLevelsPage(QueryRequest request, SagLevel sagLevel) {
        IPage<SagLevel> data = this.sagLevelService.findSagLevels(request, sagLevel);
        if (data != null) {
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping({"add"})
    public ResponseBo addSagLevel(@Valid SagLevel sagLevel) {
        if (this.sagLevelService.createSagLevel(sagLevel)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }


    @DeleteMapping({"delete"})
    public ResponseBo deleteSagLevel(SagLevel sagLevel) {
        if (this.sagLevelService.deleteSagLevel(sagLevel)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

    @PostMapping({"update"})
    public ResponseBo updateSagLevel(SagLevel sagLevel) {
        if (this.sagLevelService.updateSagLevel(sagLevel)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

}

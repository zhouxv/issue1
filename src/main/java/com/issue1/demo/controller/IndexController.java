package com.issue1.demo.controller;

import com.issue1.demo.entity.Index;
import com.issue1.demo.service.IIndexService;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller
 *
 * @author zhouxv
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"index"})
public class IndexController extends BaseController {
    private final IIndexService iIndexService;

    public IndexController(IIndexService iIndexService) {
        this.iIndexService = iIndexService;
    }

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     * <p>
     * public String groupLevelIndex(){
     * return "您的templates目录下的视图文件夹名/groupLevel/groupLevel";
     * }
     */
    @GetMapping({"getAll"})
    public ResponseBo getAllIndexs(Index index) {
        List<Index> data = iIndexService.findIndexs(index);
        if (data != null) {
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

}

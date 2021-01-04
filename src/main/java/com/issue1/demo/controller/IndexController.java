package com.issue1.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.entity.Index;
import com.issue1.demo.service.IGroupLevelService;
import com.issue1.demo.service.IIndexService;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping({"index"})
public class IndexController extends BaseController {

    @Autowired
    private IIndexService iIndexService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
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

package com.issue1.demo.controller;

import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.service.IGroupLevelService;
import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.issue1.demo.util.DTO.DtoListGroupLevel;

/**
 * Controller
 *
 * @author zhouxv
 */
@Slf4j
@Validated
@RestController
@RequestMapping({"groupLevel"})
public class GroupLevelController extends BaseController {

    private final IGroupLevelService groupLevelService;

    public GroupLevelController(IGroupLevelService groupLevelService) {
        this.groupLevelService = groupLevelService;
    }

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     * <p>
     * public String groupLevelIndex(){
     * return "您的templates目录下的视图文件夹名/groupLevel/groupLevel";
     * }
     */
    @GetMapping({"getAll"})
    public ResponseBo getAllGroupLevels(GroupLevel groupLevel) {
        List<GroupLevel> data = groupLevelService.findGroupLevels(groupLevel);
        if (data != null) {
            return ResponseBo.ok(data);
        }
        return ResponseBo.fail();
    }

    @GetMapping({"getAllDto"})
    public ResponseBo getAllGroupLevelsDto(GroupLevel groupLevel) {
        List<GroupLevel> data = groupLevelService.findGroupLevels(groupLevel);
        List<Map<String,Object>> mapList= DtoListGroupLevel(data);
        if (mapList != null) {
            return ResponseBo.ok(mapList);
        }
        return ResponseBo.fail();
    }

}

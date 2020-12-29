package com.issue1.demo.controller;

import com.issue1.dependence.common.controller.BaseController;
import com.issue1.dependence.common.entity.QueryRequest;
import com.issue1.dependence.common.entity.ResponseBo;
import com.issue1.demo.entity.GroupLevel;
import com.issue1.demo.service.IGroupLevelService;

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
@RequestMapping({"groupLevel"})
public class GroupLevelController extends BaseController {

    @Autowired
    private IGroupLevelService groupLevelService;

    /**
     * 如果你是使用的模版引擎进行渲染视图则可以生成这个返回视图,并用@Controller类前的注解@RestController换掉,后面返回json的方法记得也加上@ResponseBody
     *
     * @GetMapping("您的templates目录下的视图文件夹名" + "groupLevel")
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

    @GetMapping({"getAllPage"})
    public ResponseBo getAllGroupLevelsPage(QueryRequest request, GroupLevel groupLevel) {
        IPage<GroupLevel> data = this.groupLevelService.findGroupLevels(request, groupLevel);
        if (data != null) {
            return ResponseBo.ok(getDataTable(data));
        }
        return ResponseBo.fail();
    }


    @PostMapping({"add"})
    public ResponseBo addGroupLevel(@Valid GroupLevel groupLevel) {
        if (this.groupLevelService.createGroupLevel(groupLevel)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }


    @DeleteMapping({"delete"})
    public ResponseBo deleteGroupLevel(GroupLevel groupLevel) {
        if (this.groupLevelService.deleteGroupLevel(groupLevel)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

    @PostMapping({"update"})
    public ResponseBo updateGroupLevel(GroupLevel groupLevel) {
        if (this.groupLevelService.updateGroupLevel(groupLevel)) {
            return ResponseBo.ok();
        } else {
            return ResponseBo.fail();
        }
    }

}

package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.ClassOfflineService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.classoffline.BriefClassOffline;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.request.GetBriefListRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api("线下课程相关操作")
@RestController
@RequestMapping("/classoffline")
@Validated
public class ClassOfflineController {

    @Autowired
    private ClassOfflineService classOfflineService;

    @Autowired
    private SessionUtils sessionUtils;

    @GetMapping("/{id}")
    @ApiOperation(value = "查看线下课详情",response = ClassOffline.class)
    public Object getClassOfflineById(@PathVariable("id") Long id){
        Long user_id = sessionUtils.getUserId();
        return classOfflineService.getClassOfflineById(id,user_id);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取线下课程简要信息列表",response = BriefClassOffline.class)
    public Object getBriefClassOfflineList(@NotNull @Valid @RequestBody GetBriefListRequest request){
        return classOfflineService.getBriefClassOfflineList(request);
    }

    @Auth
    @PostMapping("/like/{id}")
    @ApiOperation(value = "点赞",response = String.class)
    public Object giveLike(@PathVariable("id") Long classOfflineId){
        classOfflineService.giveLike(sessionUtils.getUserId(),classOfflineId);
        return "操作成功";
    }

    @Auth
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除线下课（测试）",response = String.class)
    public Object deleteBook(@PathVariable("id")Long id){
        classOfflineService.deleteClassOffline(id);
        return "操作成功";
    }
}

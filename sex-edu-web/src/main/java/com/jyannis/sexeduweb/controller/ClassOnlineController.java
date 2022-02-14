package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.ClassOnlineService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.classonline.BriefClassOnline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.request.GetBriefListRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api("线上课程相关操作")
@RestController
@RequestMapping("/classonline")
@Validated
public class ClassOnlineController {

    @Autowired
    private ClassOnlineService classOnlineService;

    @Autowired
    private SessionUtils sessionUtils;

    @GetMapping("/{id}")
    @ApiOperation(value = "查看线上课程详情",response = ClassOnline.class)
    public Object getClassOnlineById(@PathVariable("id")Long id){
        Long user_id = sessionUtils.getUserId();
        return classOnlineService.getClassOnlineById(id,user_id);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取线上课程简要信息列表",response = BriefClassOnline.class)
    public Object getBriefClassOnlineList(@NotNull @Valid @RequestBody GetBriefListRequest request){
        return classOnlineService.getBriefClassOnlineList(request);
    }

    @Auth
    @PostMapping("/like/{id}")
    @ApiOperation(value = "点赞")
    public Object giveLike(@PathVariable("id") Long classOnlineId) {
        classOnlineService.giveLike(sessionUtils.getUserId(),classOnlineId);
        return "操作成功";
    }

    @Auth
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除线上课（测试）",response = String.class)
    public Object deleteBook(@PathVariable("id")Long id){
        classOnlineService.deleteClassOnline(id);
        return "操作成功";
    }
}

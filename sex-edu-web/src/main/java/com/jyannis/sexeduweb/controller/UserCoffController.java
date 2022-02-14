package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.UserCoffService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.classoffline.NotStartedClassOffline;
import com.jyannis.sexeducommon.request.PageParamRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api("线下课成员管理")
@RestController
@RequestMapping("/usercoff")
@Validated
public class UserCoffController {
    @Autowired
    private UserCoffService userCoffService;

    @Autowired
    private SessionUtils sessionUtils;

    @Auth
    @PostMapping("/signup/{class_offline_id}")
    @ApiOperation(value = "报名线下课",response = String.class)
    public Object signUpForClassOffline(@PathVariable("class_offline_id")Long class_offline_id) {
        Long user_id = sessionUtils.getUserId();
        userCoffService.signUpForClassOfflinePaying(user_id, class_offline_id);
        return "操作成功";
    }

    @Auth
    @PostMapping("/cancel/{id}")
    @ApiOperation(value = "取消线下课报名",response = String.class)
    public Object cancelClassOnline(@PathVariable("id")Long id){
        userCoffService.cancelClassOnline(id);
        return "操作成功";
    }

    @Auth
    @PostMapping("/list")
    @ApiOperation(value = "获取未开始的线下课的简要信息",response = NotStartedClassOffline.class)
    public Object getNotStartedClassOfflineListByUserId(@NotNull @Validated @RequestBody PageParamRequest pageParamRequest){
        Long userId = sessionUtils.getUserId();
        return userCoffService.getNotStartedClassOfflineByUserId(userId,pageParamRequest);
    }
}

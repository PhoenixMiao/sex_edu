package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.UserService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.SessionData;
import com.jyannis.sexeducommon.request.UpdateUserByIdRequest;
import com.jyannis.sexeducommon.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Api("用户相关操作")
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionUtils sessionUtils;

    @Auth
    @GetMapping("/info")
    @ApiOperation(value = "查看当前用户信息",response = UserResponse.class)
    public Object getUserByIdResponse(){
        Long id = sessionUtils.getUserId();
        UserResponse userResponse = userService.getUserById(id);
        return userResponse;
    }

    @Auth
    @PostMapping("/info")
    @ApiOperation(value = "更新当前用户信息",response = String.class)
    public Object updateUserById(@NotNull @Valid @RequestBody UpdateUserByIdRequest updateUserByIdRequest){
        Long id = sessionUtils.getUserId();
        userService.updateUserById(updateUserByIdRequest,id);
        return "操作成功";
    }

    @GetMapping("/login/{code}")
    @ApiOperation(value = "登录",response = SessionData.class)
    @ApiImplicitParam(name = "code", value = "code", required = true, paramType = "path")
    public Object login(@NotBlank @PathVariable("code") String code){

        return userService.login(code);

    }
}

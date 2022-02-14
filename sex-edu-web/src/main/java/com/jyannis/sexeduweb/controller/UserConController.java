package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.UserConService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.wxpay.WxPayPlaceOrderNotifyResponse;
import com.jyannis.sexeducommon.entity.PayedGoods;
import com.jyannis.sexeducommon.util.JsonUtil;
import com.jyannis.sexeduthirdparty.service.WxPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("线上课成员管理")
@RestController
@RequestMapping("/usercon")
@Validated
public class UserConController {
    @Autowired
    private UserConService userConService;

    @Autowired
    private SessionUtils sessionUtils;

    @Autowired
    private WxPayService wxPayService;

    @Auth
    @PostMapping("/buy/{class_online_id}")
    @ApiOperation(value = "购买线上课",response = String.class)
    public Object buyClassOnline(@Param("class_online_id")Long class_online_id){
        Long user_id = sessionUtils.getUserId();
        userConService.buyClassOnlinePaying(user_id,class_online_id);
        return "操作成功";
    }
}

package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.UserCoffService;
import com.jyannis.sexedubiz.service.UserConService;
import com.jyannis.sexeducommon.dto.wxpay.WxPayPlaceOrderNotifyResponse;
import com.jyannis.sexeducommon.entity.PayedGoods;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.util.JsonUtil;
import com.jyannis.sexeduthirdparty.service.WxPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("微信所需相关API")
@RestController
@RequestMapping("/wx")
@Validated
public class WxController {
    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private UserConService userConService;

    @Autowired
    private UserCoffService userCoffService;

    @GetMapping("/notify")
    @ApiOperation(value = "微信回调url",response = String.class)
    public Object buyClassOnlineNotify(WxPayPlaceOrderNotifyResponse response){
        PayedGoods payedGoods =  JsonUtil.toObject(wxPayService.placeOrderNotify(response),PayedGoods.class);
        if(payedGoods.getObject_type().equals(CommodityObjectTypeEnum.CLASS_ONLINE.getName())){
            if(userConService.buyClassOnlinePayed(payedGoods)!=null)
                return "支付成功";
        }else if(payedGoods.getObject_type().equals(CommodityObjectTypeEnum.CLASS_OFFLINE.getName())){
            if(userCoffService.signUpForClassOfflinePayed(payedGoods)!=null)
                return "支付成功";
        }
        return "支付失败";
    }
}

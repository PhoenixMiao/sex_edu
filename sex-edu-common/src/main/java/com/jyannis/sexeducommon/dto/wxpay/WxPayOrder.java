package com.jyannis.sexeducommon.dto.wxpay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter3_5_1.shtml
 * @author yannis
 * @version 2021/1/18 11:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("WxPayOrder 微信支付-下单-JSApi")
public class WxPayOrder {

    @ApiModelProperty("appId")
    private String appid;
    @ApiModelProperty("商户id")
    private String mchid;
    @ApiModelProperty("商品描述")
    private String description;
    @ApiModelProperty("回调地址")
    private String notify_url;
    @ApiModelProperty("商户订单号")
    private String out_trade_no;
    @ApiModelProperty("订单金额")
    private Amount amount;
    @ApiModelProperty("支付者")
    private Payer payer;

    @ApiModelProperty("自定义参数")
    private String attach;

}

package com.jyannis.sexeducommon.dto.wxpay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yannis
 * @version 2021/1/28 17:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("WxPayPlaceOrderNotifyResult 微信支付-回调api-返回结果")
public class WxPayPlaceOrderNotifyResult {

    @ApiModelProperty("商户id")
    private String mchid;
    @ApiModelProperty("appid")
    private String appid;
    @ApiModelProperty("119_1611816157646")
    private String out_trade_no;
    @ApiModelProperty("4200000915202101280353901346")
    private String transaction_id;
    @ApiModelProperty("JSAPI")
    private String trade_type;
    @ApiModelProperty("SUCCESS")
    private String trade_state;
    @ApiModelProperty("支付成功")
    private String trade_state_desc;
    @ApiModelProperty("OTHERS")
    private String bank_type;
    private String attach;
    @ApiModelProperty("2021-01-28T14:42:42+08:00")
    private String success_time;
    private Payer payer;
    private Amount amount;

}

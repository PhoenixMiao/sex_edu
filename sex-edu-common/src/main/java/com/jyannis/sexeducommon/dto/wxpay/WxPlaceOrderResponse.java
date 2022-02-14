package com.jyannis.sexeducommon.dto.wxpay;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yannis
 * @version 2021/1/22 17:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("WxPlaceOrderResponse 微信支付-下单-微信平台返回结果")
public class WxPlaceOrderResponse {

    private String prepay_id;
}

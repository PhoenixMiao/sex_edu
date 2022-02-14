package com.jyannis.sexeduthirdparty.api;

import com.jyannis.sexeducommon.dto.wxpay.WxPayOrder;
import com.jyannis.sexeducommon.dto.wxpay.WxPlaceOrderResponse;

/**
 * @author yannis
 * @version 2021/3/24 17:26
 */
public interface WxPayAPI {

    WxPlaceOrderResponse placeOrder(WxPayOrder wxPayOrder);

}

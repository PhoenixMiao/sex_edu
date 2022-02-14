package com.jyannis.sexeduthirdparty.api.impl;

import com.jyannis.sexeducommon.dto.wxpay.WxPayOrder;
import com.jyannis.sexeducommon.dto.wxpay.WxPlaceOrderResponse;
import com.jyannis.sexeducommon.util.HttpUtil;
import com.jyannis.sexeducommon.util.JsonUtil;
import com.jyannis.sexeducommon.util.WxPayHttpClientSingletonUtils;
import com.jyannis.sexeduthirdparty.api.WxPayAPI;
import com.jyannis.sexeduthirdparty.api.WxPayRequestUrlConstants;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yannis
 * @version 2021/3/24 17:27
 */
@Component
public class WxPayAPIImpl implements WxPayAPI {

    @Autowired
    private WxPayHttpClientSingletonUtils wxPayHttpClientSingletonUtils;

    @Override
    public WxPlaceOrderResponse placeOrder(WxPayOrder wxPayOrder) {

        HttpClient httpClient = wxPayHttpClientSingletonUtils.getHttpClient();
        String responseValue = HttpUtil.postJson(WxPayRequestUrlConstants.PLACE_ORDER_URL, null, JsonUtil.objectToMap(wxPayOrder), httpClient);
        //todo check
        return JsonUtil.toObject(responseValue, WxPlaceOrderResponse.class);

    }
}

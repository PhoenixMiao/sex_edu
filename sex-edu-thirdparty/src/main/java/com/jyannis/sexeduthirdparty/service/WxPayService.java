package com.jyannis.sexeduthirdparty.service;

import com.jyannis.sexeducommon.dto.wxpay.WxPayLauncherResponse;
import com.jyannis.sexeducommon.dto.wxpay.WxPayPlaceOrderNotifyResponse;

/**
 * @author yannis
 * @version 2021/3/24 17:34
 */
public interface WxPayService {

    /**
     * 统一下单
     * @param userId 用户id
     * @param attach 业务附加信息
     * @param notifyUrl 回调url。不包含ip和port，示例：/wx/notify
     * @param price 下单金额（单位：分）
     * @return
     */
    WxPayLauncherResponse placeOrder(Long userId, String attach, String notifyUrl, Integer price);

    /**
     * 统一下单回调处理
     * @param response
     * @return attach 业务附加信息
     */
    String placeOrderNotify(WxPayPlaceOrderNotifyResponse response);
}

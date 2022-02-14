package com.jyannis.sexeduthirdparty.service.impl;

import com.jyannis.sexeducommon.YmlConfig;
import com.jyannis.sexeducommon.common.CommonErrorCode;
import com.jyannis.sexeducommon.dto.wxpay.*;
import com.jyannis.sexeducommon.entity.User;
import com.jyannis.sexeducommon.util.*;
import com.jyannis.sexedudao.mapper.UserMapper;
import com.jyannis.sexeduthirdparty.api.WxPayAPI;
import com.jyannis.sexeduthirdparty.service.WxPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author yannis
 * @version 2021/3/24 17:41
 */
@Service
public class WxPayServiceImpl implements WxPayService {

    @Autowired
    private WxPayAPI wxPayAPI;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WxPayHttpClientSingletonUtils wxPayHttpClientSingletonUtils;

    @Autowired
    private YmlConfig ymlConfig;

    @Override
    public WxPayLauncherResponse placeOrder(Long userId, String attach, String notifyUrl, Integer price) {

        String domain = ymlConfig.getDomain();
        String port = ymlConfig.getPort();
        String appId = ymlConfig.getAppId();
        String mchId = ymlConfig.getMchId();

        Example example = new Example(User.class);
        example.selectProperties("openid");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", userId);
        User user = userMapper.selectOneByExample(example);
        if (user == null) return null;

        String openId = user.getOpenid();
        notifyUrl = domain + ":" + port + notifyUrl;

        WxPayOrder order = WxPayOrder.builder()
                .appid(appId)
                .mchid(mchId)
                .amount(
                        Amount.builder()
                                .total(price)
                                .build()
                )
                .attach(attach)
                .description("place order")
                .notify_url(notifyUrl)
                .out_trade_no(RandomNoUtil.generateOutTradeNo())
                .payer(
                        Payer.builder()
                                .openid(openId)
                                .build()
                )
                .build();

        WxPlaceOrderResponse wxPlaceOrderResponse = wxPayAPI.placeOrder(order);
        String prepay_id = wxPlaceOrderResponse.getPrepay_id();
        return new WxPayLauncherResponse(appId,prepay_id,wxPayHttpClientSingletonUtils.getPrivateKey());
    }

    @Override
    public String placeOrderNotify(WxPayPlaceOrderNotifyResponse response) {
        WxPayPlaceOrderNotifyResponse.Resource resource = response.getResource();
        String cipherText = resource.getCiphertext();
        String associatedData = resource.getAssociated_data();
        String nonce = resource.getNonce();
        String apiV3Key = ymlConfig.getApiV3Key();
        String resultString = null;
        try {
            resultString = AesUtil.decryptToString(associatedData, nonce,cipherText, apiV3Key);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WxPayPlaceOrderNotifyResult result = JsonUtil.toObject(resultString,WxPayPlaceOrderNotifyResult.class);
        checkWxPayPlaceOrderNotifyResult(result);
        return result.getAttach();
    }

    private void checkWxPayPlaceOrderNotifyResult(WxPayPlaceOrderNotifyResult result) {
        AssertUtil.notNull(result, CommonErrorCode.WX_NOTIFY_RESULT_NULL);
        AssertUtil.equals("SUCCESS",result.getTrade_state(),CommonErrorCode.WX_NOTIFY_RESULT_UNEXPECTED);
    }
}

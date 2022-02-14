package com.jyannis.sexeducommon.dto.wxpay;

import com.alibaba.fastjson.annotation.JSONField;
import com.jyannis.sexeducommon.common.CommonConstants;
import com.jyannis.sexeducommon.util.SignUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

/**
 * @author yannis
 * @version 2021/1/22 16:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("WxPayLauncherResponse 微信支付-发起支付-前端需要准备的参数 传给微信平台")
public class WxPayLauncherResponse {

    @ApiModelProperty("appId")
    private String appId;
    @ApiModelProperty("时间戳 单位秒")
    private String timeStamp;
    private String nonceStr;
    @ApiModelProperty("统一下单接口返回的prepay_id参数值")
    @JSONField(name = "package")
    private String packageString;
    @ApiModelProperty("签名类型")
    private String signType = CommonConstants.SIGN_TYPE_RSA;

    private String paySign;

    private String getSignStr(){
        return String.format("%s\n%s\n%s\n%s\n", appId, timeStamp, nonceStr, packageString);
    }

    public WxPayLauncherResponse(String appId, String prepayId, PrivateKey privateKey){
        this.appId = appId;
        timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        nonceStr = SignUtils.genRandomStr();
        packageString = "prepay_id=" + prepayId;
        paySign = SignUtils.sign(getSignStr(), privateKey);
    }

}

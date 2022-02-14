package com.jyannis.sexeducommon.dto.wxpay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yannis
 * @version 2021/1/18 11:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Payer 微信支付-下单api-支付者")
public class Payer {

    @ApiModelProperty("支付者的openid")
    private String openid;

}

package com.jyannis.sexeducommon.dto.wxpay;

import com.jyannis.sexeducommon.common.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yannis
 * @version 2021/1/18 11:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Amount 微信支付-下单api-订单金额 / 退款api-订单金额")
public class Amount {

    @ApiModelProperty("总金额（单位：分）")
    private Integer total;
    @ApiModelProperty("币种")
    private String currency = CommonConstants.CNY_CURRENCY;
    @ApiModelProperty("退款api-退款金额（单位：分）")
    private Integer refund;
}

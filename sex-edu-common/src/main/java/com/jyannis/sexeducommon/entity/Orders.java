package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("orders 订单")
public class Orders {
    @Id
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("用户id")
    private Long user_id;
    @ApiModelProperty("业务附加信息")
    private String biz_attach;
    @ApiModelProperty("微信支付单号")
    private String wx_transaction_id;
    @ApiModelProperty("商品订单号")
    private String out_trade_no;
    @ApiModelProperty("付款时间")
    private String pay_time;
    @ApiModelProperty("状态")
    private String status;
}

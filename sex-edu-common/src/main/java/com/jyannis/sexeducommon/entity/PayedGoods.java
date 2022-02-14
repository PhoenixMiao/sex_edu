package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("PayedGoods 已支付商品")
public class PayedGoods {
    @Id
    @NotNull
    @ApiModelProperty("id")
    private Long id;
    @Id
    @ApiModelProperty("用户id")
    private Long user_id;
    @ApiModelProperty("商品类型")
    private String object_type;
    @ApiModelProperty("商品id")
    private Long object_id;
    @ApiModelProperty("支付金额（单位：分）")
    private int price;
    @ApiModelProperty("支付时间")
    private String create_time;
}

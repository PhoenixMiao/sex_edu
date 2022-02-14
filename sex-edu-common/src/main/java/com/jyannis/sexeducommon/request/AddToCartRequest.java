package com.jyannis.sexeducommon.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("AddToCartRequest 加入购物车")
public class AddToCartRequest {
    @ApiModelProperty("商品类型")
    private String goods_type;
    @NotNull
    @ApiModelProperty("商品id")
    private Long goods_id;
    //如果是图书商品请加数量，如果不是可不加，结果不会显示
    @ApiModelProperty("商品数量")
    private int goods_quantity;

}

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
@ApiModel("NewQuantityRequest 修改购物车中的商品数量")
public class NewQuantityRequest {
    @NotNull
    @ApiModelProperty("购物车中的id")
    private Long id;
    @NotNull
    @ApiModelProperty("商品数量")
    private int goods_quantity;
}

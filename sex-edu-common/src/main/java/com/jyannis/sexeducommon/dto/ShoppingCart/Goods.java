package com.jyannis.sexeducommon.dto.ShoppingCart;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Goods 商品")
public class Goods implements Serializable {

    /**
     * {@link com.jyannis.sexeducommon.entity.ShoppingCart}
     */

    @ApiModelProperty("商品类型")
    private String goods_type;
    @ApiModelProperty("商品id")
    private Long goods_id;
    @ApiModelProperty("商品名称")
    private String goods_name;
    @ApiModelProperty("商品出处")
    private String goods_source;
    @ApiModelProperty("商品图片")
    private String pic;
    @ApiModelProperty("商品价格")
    private Double price;
}

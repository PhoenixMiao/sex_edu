package com.jyannis.sexeducommon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("SearchGoods 搜索所得商品")
public class SearchGoods {

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
    @ApiModelProperty("点赞数")
    private int likes;
    @ApiModelProperty("浏览量")
    private int browse;
}

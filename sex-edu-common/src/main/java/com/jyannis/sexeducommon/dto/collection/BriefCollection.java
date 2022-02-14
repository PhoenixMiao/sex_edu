package com.jyannis.sexeducommon.dto.collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("BriefCollection 收藏的商品简要信息")
public class BriefCollection implements Serializable {
    /**
     * {@link com.jyannis.sexeducommon.entity.Collection}
     */

    @ApiModelProperty("收藏id")
    private Long id;
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

package com.jyannis.sexeducommon.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("AddToCollection 收藏商品")
public class AddToCollectionRequest {
    @ApiModelProperty("商品类型")
    private String type;
    @ApiModelProperty("商品id")
    private Long object_id;
}

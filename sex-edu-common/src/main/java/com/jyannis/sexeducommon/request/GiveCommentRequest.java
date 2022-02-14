package com.jyannis.sexeducommon.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("GiveCommentRequest 做评价")
public class GiveCommentRequest {
    @NotNull
    @ApiModelProperty("商品类型")
    private String object_type;
    @ApiModelProperty("商品id")
    private Long object_id;
    @ApiModelProperty("星级")
    private int star;
    @ApiModelProperty("内容")
    private String contents;
}

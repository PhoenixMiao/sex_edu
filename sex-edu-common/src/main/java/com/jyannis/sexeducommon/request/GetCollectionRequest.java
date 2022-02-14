package com.jyannis.sexeducommon.request;

import com.jyannis.sexeducommon.common.PageParam;
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
@ApiModel("GetCollectionRequest 查看收藏商品")
public class GetCollectionRequest {
    @NotNull
    @ApiModelProperty("分页参数")
    private PageParam pageParam;
    @NotNull
    @ApiModelProperty("对象类型")
    private String type;
}

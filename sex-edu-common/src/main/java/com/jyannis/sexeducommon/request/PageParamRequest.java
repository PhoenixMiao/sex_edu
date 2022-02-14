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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("PageParam 分页参数")
public class PageParamRequest {
    @NotNull
    @ApiModelProperty("分页参数")
    PageParam pageParam;
}

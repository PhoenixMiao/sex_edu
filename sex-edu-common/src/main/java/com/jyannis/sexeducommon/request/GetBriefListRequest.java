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
@ApiModel("GetBriefListRequest 获取图书、线上课、线下课简要信息列表")
public class GetBriefListRequest {
    @NotNull
    @ApiModelProperty("分页参数")
    PageParam pageParam;
    @NotNull
    @ApiModelProperty("对象类型")
    String type;
}
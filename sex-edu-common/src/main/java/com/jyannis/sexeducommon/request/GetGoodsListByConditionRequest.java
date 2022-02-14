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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("GetGoodsListByConditionRequest 根据条件搜索商品(填入哪个就按哪个条件搜索，不作为搜索条件的就不用填)")
public class GetGoodsListByConditionRequest {

    @NotNull
    @ApiModelProperty("分页参数")
    PageParam pageParam;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("图书")
    private String book;
    @ApiModelProperty("线上课")
    private String class_online;
    @ApiModelProperty("线下课")
    private String class_offline;
    @ApiModelProperty("开发商")
    private String developer;

}

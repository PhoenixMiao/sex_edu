package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("advice 建议")
public class Advice {
    @Id
    @ApiModelProperty("id")
    private Long id;
    @Id
    @ApiModelProperty("用户id")
    private Long user_id;
    @ApiModelProperty("意见内容")
    private String content;
    @ApiModelProperty("图片")
    private String pictures;
    @ApiModelProperty("创建时间")
    private String create_time;
    @ApiModelProperty("状态")
    private int status;
}

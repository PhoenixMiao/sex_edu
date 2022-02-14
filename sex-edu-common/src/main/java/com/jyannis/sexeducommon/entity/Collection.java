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
@ApiModel("Collection 收藏")
public class Collection {
    @Id
    @ApiModelProperty("id")
    private Long id;
    @Id
    @ApiModelProperty("用户id")
    private Long user_id;
    @ApiModelProperty("类别")
    private String type;
    @ApiModelProperty("收藏对象的id")
    private Long object_id;
    @ApiModelProperty("收藏时间")
    private String create_time;
}

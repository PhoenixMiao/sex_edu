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
@ApiModel("User_con 线上课成员")
public class UserCon {
    @Id
    @ApiModelProperty("id")
    private Long id;
    @Id
    @ApiModelProperty("用户id")
    private Long user_id;
    @ApiModelProperty("线上课id")
    private Long class_online_id;
    @ApiModelProperty("购买时间")
    private String create_time;
}

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
@ApiModel("User_coff 线下课成员")
public class UserCoff {
    @Id
    @ApiModelProperty("id")
    private Long id;
    @Id
    @ApiModelProperty("用户id")
    private Long user_id;
    @ApiModelProperty("线下课id")
    private Long class_offline_id;
    @ApiModelProperty("报名时间")
    private String create_time;
}

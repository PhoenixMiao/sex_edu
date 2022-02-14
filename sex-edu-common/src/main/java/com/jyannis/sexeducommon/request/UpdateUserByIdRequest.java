package com.jyannis.sexeducommon.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("UpdateUserByIdRequest 更新用户信息")
public class UpdateUserByIdRequest {
    /**
     * {@link com.jyannis.sexeducommon.entity.User}
     */

    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("性别")
    private int gender;
    @ApiModelProperty("电话号码")
    private String telephone;
    @ApiModelProperty("收货地址")
    private String address;
    @ApiModelProperty("头像")
    private String portrait;
}

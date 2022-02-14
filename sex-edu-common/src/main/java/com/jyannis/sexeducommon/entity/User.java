package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


/**
 * @author lishuai
 * @version 2021/2/2 21:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("User 用户")
public class User {

	@Id
	@ApiModelProperty("用户id")
	private Long id;
	@ApiModelProperty("会话id")
	private String session_id;
    @ApiModelProperty("用户唯一标识")
	private String openid;
    @ApiModelProperty("unionid")
	private String unionid;
    @ApiModelProperty("会话密钥")
	private String session_key;
    @ApiModelProperty("创建时间")
	private String create_time;
    @ApiModelProperty("昵称")
	private String nickname;
    @ApiModelProperty("性别")
	private Integer gender;
    @ApiModelProperty("头像")
	private String portrait;
	@ApiModelProperty("收货地址")
	private String address;
	@ApiModelProperty("电话号码")
	private String telephone;

}

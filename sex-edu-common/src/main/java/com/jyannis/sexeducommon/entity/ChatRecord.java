package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("chat_record 聊天记录")
public class ChatRecord {

    @Id
    @ApiModelProperty("Id")
    private Long id;
    @ApiModelProperty("发消息的用户id")
    private Long user_from;
    @ApiModelProperty("接受消息的用户id")
    private Long user_to;
    @ApiModelProperty("聊天记录")
    private Long content;
    @ApiModelProperty("创建时间")
    private String create_time;
    @ApiModelProperty("聊天记录状态")
    private int status;
}

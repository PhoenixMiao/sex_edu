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
@ApiModel("SendMessageRequest 发送消息")
public class SendMessageRequest {
    @ApiModelProperty("接收消息的用户id")
    private Long user_to;
    @ApiModelProperty("聊天内容")
    private String content;
}

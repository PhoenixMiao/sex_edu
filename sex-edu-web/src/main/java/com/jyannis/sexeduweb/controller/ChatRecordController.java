package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.ChatRecordService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.entity.ChatRecord;
import com.jyannis.sexeducommon.request.SendMessageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api("聊天记录相关操作")
@RestController
@RequestMapping("/chat")
@Validated
public class ChatRecordController {
    @Autowired
    private ChatRecordService chatRecordService;

    @Autowired
    private SessionUtils sessionUtils;

    @Auth
    @PostMapping("/send")
    @ApiOperation(value = "发送信息",response = String.class)
    public Object sendMessage(@NotNull @Valid @RequestBody SendMessageRequest sendMessageRequest){
        chatRecordService.sendMessage(sendMessageRequest,sessionUtils.getUserId());
        return "操作成功";
    }

    @Auth
    @GetMapping("/read/{id}")
    @ApiOperation(value = "读消息",response = ChatRecord.class)
    public Object readMessage(@PathVariable("id")Long id){
        return chatRecordService.readMessage(id);
    }

    @Auth
    @GetMapping("/list")
    @ApiOperation(value = "获取消息列表",response = ChatRecord.class)
    public Object getChatRecordList(){
        return chatRecordService.getChatRecordList(sessionUtils.getUserId());
    }

    @Auth
    @PostMapping("/clear")
    @ApiOperation(value = "清除未读消息",response = String.class)
    public Object haveReadMessage(){
        chatRecordService.haveReadMessage(sessionUtils.getUserId());
        return "操作成功";
    }

    @Auth
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除一条消息",response = String.class)
    public Object deleteMessage(@PathVariable("id")Long id){
        chatRecordService.deleteMessage(id);
        return "操作成功";
    }
}

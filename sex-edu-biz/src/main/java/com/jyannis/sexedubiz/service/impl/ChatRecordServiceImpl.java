package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.jyannis.sexedubiz.service.ChatRecordService;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.entity.ChatRecord;
import com.jyannis.sexeducommon.request.SendMessageRequest;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.ChatRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRecordServiceImpl implements ChatRecordService {
    @Autowired
    private ChatRecordMapper chatRecordMapper;

    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest, Long user_id){
        String create_time = TimeUtil.getCurrentTimestamp();
        chatRecordMapper.sendMessage(user_id,sendMessageRequest.getUser_to(),sendMessageRequest.getContent(),create_time,0);
    }

    @Override
    public ChatRecord readMessage(Long id){
        ChatRecord chatRecord = chatRecordMapper.getMessageById(id);
        chatRecordMapper.readMessage(1,id);
        return chatRecord;
    }

    @Override
    public List<ChatRecord> getChatRecordList(Long user_id){
        return chatRecordMapper.getChatRecordList(user_id);
    }

    @Override
    public void haveReadMessage(Long user_id){
        List<Long> id = chatRecordMapper.getUnreadMessage(user_id,0);
        for(Long e:id){
            chatRecordMapper.readMessage(1,e);
        }
    }

    @Override
    public void deleteMessage(Long id){
        chatRecordMapper.deleteMessage(id);
    }
}

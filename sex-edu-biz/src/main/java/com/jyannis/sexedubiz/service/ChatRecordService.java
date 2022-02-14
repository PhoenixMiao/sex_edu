package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.entity.ChatRecord;
import com.jyannis.sexeducommon.request.SendMessageRequest;

import java.util.List;

public interface ChatRecordService {
    void sendMessage(SendMessageRequest sendMessageRequest,Long user_id);
    ChatRecord readMessage(Long id);
    List<ChatRecord> getChatRecordList(Long user_id);
    void haveReadMessage(Long user_id);
    void deleteMessage(Long id);
}

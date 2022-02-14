package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.entity.ChatRecord;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ChatRecordMapper extends MyMapper<ChatRecord> {
    @Insert("INSERT INTO chat_record VALUE (null,#{user_from},#{user_to},#{content},#{create_time},#{status});")
    void sendMessage(@Param("user_from")Long user_from,
                     @Param("user_to")Long user_to,
                     @Param("content")String content,
                     @Param("create_time")String create_time,
                     @Param("status")int status);

    @Select("SELECT * FROM chat_record WHERE id = #{id};")
    ChatRecord getMessageById(@Param("id")Long id);

    @Select("SELECT * FROM chat_record WHERE user_to = #{user_id} OR user_from = #{user_id};")
    List<ChatRecord> getChatRecordList(@Param("user_id")Long user_id);

    @Update("UPDATE chat_record SET status = #{status} WHERE id = #{id};")
    void readMessage(@Param("status")int status,
                     @Param("id")Long id);

    @Select("SELECT id FROM chat_record WHERE user_to = #{user_id} AND status = #{status};")
    List<Long> getUnreadMessage(@Param("user_id")Long user_id,
                                @Param("status")int status);

    @Delete("DELETE FROM chat_record WHERE id = #{id};")
    void deleteMessage(@Param("id")Long id);
}

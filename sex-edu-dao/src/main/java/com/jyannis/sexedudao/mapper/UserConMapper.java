package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.entity.UserCon;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserConMapper extends MyMapper<UserCon> {
    @Insert("INSERT INTO user_con VALUE(null,#{user_id},#{class_online_id},#{create_time});")
    void buyClassOnline(@Param("user_id") Long user_id,
                        @Param("class_online_id") Long class_online_id,
                        @Param("create_time") String create_time);
}

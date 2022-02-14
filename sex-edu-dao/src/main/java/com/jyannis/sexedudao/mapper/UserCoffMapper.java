package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.entity.UserCoff;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserCoffMapper extends MyMapper<UserCoff> {

    @Insert("INSERT INTO user_coff VALUE(null,#{user_id},#{class_offline_id},#{create_time});")
    void signUpForClassOnline(@Param("user_id") Long user_id,
                              @Param("class_offline_id") Long class_offline_id,
                              @Param("create_time") String create_time);

    @Delete("DELETE FROM user_coff WHERE id=#{id};")
    void cancelClassOnline(@Param("id") Long id);

    @Select("SELECT * FROM user_coff WHERE user_id=#{user_id}")
    List<UserCoff> getUserCoffListByUserId(@Param("user_id") Long user_id);
}

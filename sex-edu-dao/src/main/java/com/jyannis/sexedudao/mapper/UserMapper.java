package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.response.UserResponse;
import com.jyannis.sexeducommon.entity.User;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author yannis
 * @version 2020/11/7 9:17
 */

@Repository
public interface UserMapper extends MyMapper<User> {

    @Select("SELECT nickname,gender,telephone,address,portrait FROM user WHERE id=#{id};")
    UserResponse getUserById(@Param("id") Long id);

    @Update("UPDATE user SET nickname = #{nickname},gender = #{gender},portrait = #{portrait},address = #{address},telephone = #{telephone} WHERE id=#{id};")
    void updateUserById(@Param("nickname") String nickname,
                        @Param("gender") int gender,
                        @Param("portrait") String portrait,
                        @Param("address") String address,
                        @Param("telephone") String telephone,
                        @Param("id") Long id);
}

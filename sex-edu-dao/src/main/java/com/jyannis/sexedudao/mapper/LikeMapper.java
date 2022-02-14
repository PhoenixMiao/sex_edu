
package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.browse.BriefBrowse;
import com.jyannis.sexeducommon.entity.Like;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface LikeMapper extends MyMapper<Like> {
    @Insert("INSERT INTO likes VALUES (null,#{user_id},#{type},#{object_id},#{create_time});")
    int insertLike(@Param("user_id") Long user_id,
                   @Param("type") String type,
                   @Param("object_id") Long object_id,
                   @Param("create_time") String create_time);

    @Select("SELECT id FROM likes WHERE user_id = #{user_id} AND object_id = #{object_id};")
    Long getLike(@Param("user_id") Long user_id,
                 @Param("object_id") Long object_id);
}
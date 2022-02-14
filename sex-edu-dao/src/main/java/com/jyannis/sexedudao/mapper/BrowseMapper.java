package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.browse.BriefBrowse;
import com.jyannis.sexeducommon.entity.Browse;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrowseMapper extends MyMapper<Browse> {
    @Select("SELECT type,object_id,create_time FROM browse WHERE user_id = #{user_id};")
    List<BriefBrowse> getBrowseList(Long user_id);

    @Insert("INSERT INTO browse VALUES (null,#{user_id},#{type},#{object_id},#{create_time});")
    int insertBrowse(@Param("user_id") Long user_id,
                     @Param("type") String type,
                     @Param("object_id") Long object_id,
                     @Param("create_time") String create_time);
}

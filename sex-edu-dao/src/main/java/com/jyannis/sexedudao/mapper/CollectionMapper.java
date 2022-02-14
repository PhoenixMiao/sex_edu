package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.entity.Collection;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CollectionMapper extends MyMapper<Collection> {
    @Insert("INSERT INTO collection VALUE(null,#{user_id},#{type},#{object_id},#{create_time})")
    void addToCollection(@Param("user_id") Long user_id,
                         @Param("type") String type,
                         @Param("object_id") Long object_id,
                         @Param("create_time") String create_time);

    @Delete("DELETE FROM collection WHERE id=#{id};")
    void cancelCollection(@Param("id") Long id);

    @Select("SELECT * FROM collection WHERE user_id = #{user_id}")
    List<Collection> getCollectionList(@Param("user_id") Long user_id);
}

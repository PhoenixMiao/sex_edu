package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.classoffline.BriefClassOffline;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassOfflineMapper extends MyMapper<ClassOffline>{

    @Select("SELECT * FROM class_offline WHERE id = #{id};")
    ClassOffline getClassOfflineById(@Param("id") Long id);

    @Select("SELECT id,name,description,age_floor,age_ceiling,sub_type,pic,likes,browse,type FROM class_offline WHERE type=#{type}")
    List<BriefClassOffline> getBriefClassOfflineList(@Param("type") String type);

    @Select("SELECT * FROM class_offline WHERE name=#{name};")
    List<ClassOffline> searchClassOfflineByName(@Param("name") String name);

    @Select("SELECT * FROM class_offline WHERE address=#{address};")
    List<ClassOffline> searchClassOfflineByAddress(@Param("address") String address);

    @Select("SELECT likes FROM class_offline WHERE id=#{id};")
    int getLikes(@Param("id") Long id);

    @Update("UPDATE class_offline SET likes=#{likes} WHERE id=#{id};")
    void giveLike(@Param("likes") int likes, @Param("id") Long id);

    @Select("SELECT browse FROM class_offline WHERE id=#{id};")
    int getBrowse(@Param("id") Long id);

    @Update("UPDATE class_offline SET browse=#{browse} WHERE id=#{id};")
    void addBrowse(@Param("browse") int browse, @Param("id") Long id);

    @Delete("DELETE FROM class_offline WHERE id=#{id};")
    void deleteClassOffline(@Param("id") Long id);
}

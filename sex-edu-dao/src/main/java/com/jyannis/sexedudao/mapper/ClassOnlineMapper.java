package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.classonline.BriefClassOnline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassOnlineMapper extends MyMapper<ClassOnline>{

    @Select("SELECT * FROM class_online WHERE id = #{id};")
    ClassOnline getClassOnlineById(@Param("id") Long id);

    @Select("SELECT id,name,description,age_floor,age_ceiling,sub_type,pic,likes,browse,type FROM class_online WHERE type=#{type}")
    List<BriefClassOnline> getBriefClassOnlineList(@Param("type") String type);

    @Select("SELECT * FROM class_online WHERE name=#{name};")
    List<ClassOnline> searchClassOnlineByName(@Param("name") String name);

    @Select("SELECT * FROM class_online WHERE lecturer=#{lecturer};")
    List<ClassOnline> searchClassOnlineByLecturer(@Param("lecturer") String lecturer);

    @Select("SELECT likes FROM class_online WHERE id=#{id}")
    int getLikes(@Param("id") Long id);

    @Update("UPDATE class_online SET likes=#{likes} WHERE id=#{id};")
    void giveLike(@Param("likes") int likes, @Param("id") Long id);

    @Select("SELECT browse FROM class_online WHERE id=#{id};")
    int getBrowse(@Param("id") Long id);

    @Update("UPDATE class_online SET browse=#{browse} WHERE id=#{id};")
    void addBrowse(@Param("browse") int browse, @Param("id") Long id);

    @Delete("DELETE FROM class_onlineWHERE id=#{id};")
    void deleteClassOnline(@Param("id") Long id);
}

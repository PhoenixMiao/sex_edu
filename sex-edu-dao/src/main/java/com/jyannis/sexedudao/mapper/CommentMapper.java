package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.ShoppingCart.SimpleGoods;
import com.jyannis.sexeducommon.entity.Comment;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {
    @Insert("INSERT INTO comment VALUE(null,#{user_id},#{object_type},#{object_id},#{star},0,#{create_time},#{contents})")
    void giveComment(@Param("user_id") Long user_id,
                     @Param("object_type") String object_type,
                     @Param("object_id") Long object_id,
                     @Param("star") int star,
                     @Param("create_time") String create_time,
                     @Param("contents") String contents);

    @Select("SELECT likes FROM comment WHERE id=#{id}")
    int getLikes(@Param("id") Long id);

    @Update("UPDATE comment SET likes=#{likes} WHERE id=#{id};")
    void giveLike(@Param("likes") int likes, @Param("id") Long id);

    @Select("SELECT id,object_type,object_id FROM comment WHERE user_id = #{user_id};")
    List<SimpleGoods> getCommentedGoodsList(@Param("user_id") Long user_id);
}

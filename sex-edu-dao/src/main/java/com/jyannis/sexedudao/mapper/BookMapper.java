package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.book.BriefBook;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper extends MyMapper<Book> {

    @Select("SELECT * FROM book WHERE id=#{id}")
    Book getBookById(@Param("id") Long id);

    @Select("SELECT id,name,description,age_floor,age_ceiling,sub_type,pic,likes,browse,sub_type FROM book WHERE type=#{type}")
    List<BriefBook> getBriefBookList(@Param("type") String type);

    @Select("SELECT * FROM book WHERE name=#{name}")
    List<Book> searchBookByName(@Param("name") String name);

    @Select("SELECT * FROM book WHERE writer=#{writer}")
    List<Book> searchBookByWriter(@Param("writer") String writer);

    @Select("SELECT likes FROM book WHERE id=#{id}")
    int getLikes(@Param("id") Long id);

    @Update("UPDATE book SET likes=#{likes} WHERE id=#{id};")
    void giveLike(@Param("likes") int likes, @Param("id") Long id);

    @Select("SELECT browse FROM book WHERE id=#{id}")
    int getBrowse(@Param("id") Long id);

    @Update("UPDATE book SET browse=#{browse} WHERE id=#{id}")
    void addBrowse(@Param("browse") int browse, @Param("id") Long id);

    @Delete("DELETE FROM book WHERE id=#{id};")
    void deleteBook(@Param("id") Long id);
}

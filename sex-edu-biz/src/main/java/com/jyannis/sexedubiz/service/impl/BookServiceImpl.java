package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.BookService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.book.BriefBook;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.entity.Browse;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.enums.CommodityTypeEnum;
import com.jyannis.sexeducommon.request.GetBriefListRequest;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.BookMapper;
import com.jyannis.sexedudao.mapper.BrowseMapper;
import com.jyannis.sexedudao.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BrowseMapper browseMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public Book getBookById (Long id, Long user_id){
        Book book = bookMapper.getBookById(id);
        if(user_id != null) {
        String create_time = TimeUtil.getCurrentTimestamp();
        createBrowse(user_id,id,create_time);
        }
        int browse = bookMapper.getBrowse(id)+1;
        bookMapper.addBrowse(browse,id);
        return book;
    }

    @Override
     public Page<BriefBook> getBriefBookList(GetBriefListRequest request){
        if(request == null) return null;

        PageParam pageParam = request.getPageParam();
        //pageParam.setOrderBy("create_time");
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
        if(request.getType().equals(CommodityTypeEnum.CHILDREN.getName())){
            List<BriefBook> briefBookList = bookMapper.getBriefBookList(CommodityTypeEnum.CHILDREN.getName());
            return new Page(new PageInfo<>(briefBookList));
        }else if(request.getType().equals(CommodityTypeEnum.PARENTS.getName())){
            List<BriefBook> briefBookList = bookMapper.getBriefBookList(CommodityTypeEnum.PARENTS.getName());
            return new Page(new PageInfo<>(briefBookList));
        }else if(request.getType().equals(CommodityTypeEnum.TEACHER.getName())){
            List<BriefBook> briefBookList = bookMapper.getBriefBookList(CommodityTypeEnum.TEACHER.getName());
            return new Page(new PageInfo<>(briefBookList));
        }
        return null;
    }


    private Browse createBrowse(Long user_id, Long object_id, String create_time){
        String type = CommodityObjectTypeEnum.BOOK.getName();
        Browse browse = new Browse(null,user_id,type,object_id,create_time);
        browseMapper.insertBrowse(browse.getUser_id(), browse.getType(),browse.getObject_id(),browse.getCreate_time());
        return browse;
    }

    @Override
    public void giveLike(Long user_id,Long id){
        if(likeMapper.getLike(user_id,id)==null){
            int likes = bookMapper.getLikes(id)+1;
            bookMapper.giveLike(likes,id);
            String create_time = TimeUtil.getCurrentTimestamp();
            likeMapper.insertLike(user_id,CommodityObjectTypeEnum.BOOK.getName(), id,create_time);
        }
    }

    @Override
    public void deleteBook(Long id){
        bookMapper.deleteBook(id);
    }
}

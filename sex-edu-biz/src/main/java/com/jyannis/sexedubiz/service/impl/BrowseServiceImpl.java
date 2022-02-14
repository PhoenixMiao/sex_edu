package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.BrowseService;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.browse.BriefBrowse;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.request.PageParamRequest;
import com.jyannis.sexedudao.mapper.BookMapper;
import com.jyannis.sexedudao.mapper.BrowseMapper;
import com.jyannis.sexedudao.mapper.ClassOfflineMapper;
import com.jyannis.sexedudao.mapper.ClassOnlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseServiceImpl implements BrowseService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ClassOnlineMapper classOnlineMapper;

    @Autowired
    private ClassOfflineMapper classOfflineMapper;

    @Autowired
    private BrowseMapper browseMapper;

    @Override
    public Page<BriefBrowse> getBrowseList(PageParamRequest request, Long user_id){
        if(request == null) return null;

        if(user_id != null){
            PageParam pageParam = request.getPageParam();
            //pageParam.setOrderBy("create_time");
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
            List<BriefBrowse> browseList = browseMapper.getBrowseList(user_id);
            for(BriefBrowse e : browseList){
                if(e.getType().equals(CommodityObjectTypeEnum.BOOK.getName())){
                    Book book = bookMapper.getBookById(e.getObject_id());
                    e.setName(book.getName());
                    e.setDescription(book.getDescription());
                    e.setPic(book.getPic());
                }else if(e.getType().equals(CommodityObjectTypeEnum.CLASS_OFFLINE.getName())){
                    ClassOffline classOffline = classOfflineMapper.getClassOfflineById(e.getObject_id());
                    e.setName(classOffline.getName());
                    e.setDescription(classOffline.getDescription());
                    e.setPic(classOffline.getPic());
                }else if(e.getType().equals(CommodityObjectTypeEnum.CLASS_ONLINE.getName())){
                    ClassOnline classOnline = classOnlineMapper.getClassOnlineById(e.getObject_id());
                    e.setName(classOnline.getName());
                    e.setDescription(classOnline.getDescription());
                    e.setPic(classOnline.getPic());
                }
            }
            return new Page(new PageInfo<>(browseList));
        }
        return null;
    }
}

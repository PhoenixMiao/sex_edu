package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.CollectionService;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.collection.BriefCollection;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.entity.Collection;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.request.GetCollectionRequest;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.BookMapper;
import com.jyannis.sexedudao.mapper.ClassOfflineMapper;
import com.jyannis.sexedudao.mapper.ClassOnlineMapper;
import com.jyannis.sexedudao.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ClassOfflineMapper classOfflineMapper;

    @Autowired
    private ClassOnlineMapper classOnlineMapper;

    @Override
    public void addToCollection(Long user_id,String type,Long object_id){
        String create_time = TimeUtil.getCurrentTimestamp();
        collectionMapper.addToCollection(user_id,type,object_id,create_time);
    }

    @Override
    public void cancelCollection(Long id){
        collectionMapper.cancelCollection(id);
    }

    @Override
    public Page<BriefCollection> getBriefCollectionList(GetCollectionRequest getCollectionRequest, Long user_id){
        String type = getCollectionRequest.getType();
        List<Collection> collectionList = collectionMapper.getCollectionList(user_id);
        List<BriefCollection> briefCollectionList = new ArrayList<>();
        for(Collection e : collectionList){
            if(type.equals(CommodityObjectTypeEnum.BOOK.getName())){
                if(e.getType().equals(CommodityObjectTypeEnum.BOOK.getName())) {
                    Book book = bookMapper.getBookById(e.getObject_id());
                    BriefCollection briefCollection = new BriefCollection(e.getId(),e.getType(), e.getObject_id(), book.getName(), book.getWriter(), book.getPic(), book.getPrice());
                    briefCollectionList.add(briefCollection);
                }
            }else if(type.equals(CommodityObjectTypeEnum.CLASS_OFFLINE.getName())){
                if(e.getType().equals(CommodityObjectTypeEnum.CLASS_OFFLINE.getName())) {
                    ClassOffline classOffline = classOfflineMapper.getClassOfflineById(e.getObject_id());
                    BriefCollection briefCollection = new BriefCollection(e.getId(),e.getType(), e.getObject_id(), classOffline.getName(), classOffline.getAddress(), classOffline.getPic(), classOffline.getPrice());
                    briefCollectionList.add(briefCollection);
                }
            }else if(type.equals(CommodityObjectTypeEnum.CLASS_ONLINE.getName())){
                if(e.getType().equals(CommodityObjectTypeEnum.CLASS_ONLINE.getName())) {
                    ClassOnline classOnline = classOnlineMapper.getClassOnlineById(e.getObject_id());
                    BriefCollection briefCollection = new BriefCollection(e.getId(),e.getType(), e.getObject_id(),classOnline.getName(),classOnline.getLecturer(),classOnline.getPic(),classOnline.getPrice());
                    briefCollectionList.add(briefCollection);
                }
            }
        }
        for(Collection e : collectionList){
            if(type.equals(CommodityObjectTypeEnum.ALL.getName())){
                if(e.getType().equals(CommodityObjectTypeEnum.BOOK.getName())) {
                    Book book = bookMapper.getBookById(e.getObject_id());
                    BriefCollection briefCollection = new BriefCollection(e.getId(),e.getType(), e.getObject_id(), book.getName(), book.getWriter(), book.getPic(), book.getPrice());
                    briefCollectionList.add(briefCollection);
                }else if(e.getType().equals(CommodityObjectTypeEnum.CLASS_OFFLINE.getName())) {
                    ClassOffline classOffline = classOfflineMapper.getClassOfflineById(e.getObject_id());
                    BriefCollection briefCollection = new BriefCollection(e.getId(),e.getType(), e.getObject_id(), classOffline.getName(), classOffline.getAddress(), classOffline.getPic(), classOffline.getPrice());
                    briefCollectionList.add(briefCollection);
                }else if(e.getType().equals(CommodityObjectTypeEnum.CLASS_ONLINE.getName())) {
                    ClassOnline classOnline = classOnlineMapper.getClassOnlineById(e.getObject_id());
                    BriefCollection briefCollection = new BriefCollection(e.getId(),e.getType(), e.getObject_id(),classOnline.getName(),classOnline.getLecturer(),classOnline.getPic(),classOnline.getPrice());
                    briefCollectionList.add(briefCollection);
                }
            }
        }

        PageParam pageParam = getCollectionRequest.getPageParam();
        //pageParam.setOrderBy("create_time");
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
        return new Page(new PageInfo<>(briefCollectionList));
    }
}

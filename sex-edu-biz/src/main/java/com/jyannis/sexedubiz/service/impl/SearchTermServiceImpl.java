package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.SearchTermService;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.SearchGoods;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.request.GetGoodsListByConditionRequest;
import com.jyannis.sexedudao.mapper.BookMapper;
import com.jyannis.sexedudao.mapper.ClassOfflineMapper;
import com.jyannis.sexedudao.mapper.ClassOnlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchTermServiceImpl implements SearchTermService {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ClassOnlineMapper classOnlineMapper;

    @Autowired
    private ClassOfflineMapper classOfflineMapper;

    @Override
    public Page<SearchGoods> getGoodsListByCondition(GetGoodsListByConditionRequest getGoodsListByConditionRequest){
        if(getGoodsListByConditionRequest == null) return null;

        PageParam pageParam = getGoodsListByConditionRequest.getPageParam();
        //pageParam.setOrderBy("create_time");
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
        List<SearchGoods> searchGoodsList= new ArrayList<SearchGoods>();
        if(getGoodsListByConditionRequest.getName()!=null){
            List<Book> bookList = bookMapper.searchBookByName(getGoodsListByConditionRequest.getName());
            if(!bookList.isEmpty()){
                for(Book e:bookList){
                    SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.BOOK.getName(),e.getId(),e.getName(),e.getWriter(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                    searchGoodsList.add(searchGoods);
                }
            }
            List<ClassOnline> classOnlineList = classOnlineMapper.searchClassOnlineByName(getGoodsListByConditionRequest.getName());
            if(!classOnlineList.isEmpty()){
                for(ClassOnline e:classOnlineList){
                    SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.CLASS_ONLINE.getName(),e.getId(),e.getName(),e.getLecturer(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                    searchGoodsList.add(searchGoods);
                }
            }

            List<ClassOffline> classOfflineList = classOfflineMapper.searchClassOfflineByName(getGoodsListByConditionRequest.getName());
            if(!classOfflineList.isEmpty()){
                for(ClassOffline e:classOfflineList){
                    SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.CLASS_OFFLINE.getName(),e.getId(),e.getName(),e.getAddress(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                    searchGoodsList.add(searchGoods);
                }
            }
        }else if(getGoodsListByConditionRequest.getBook()!=null){
            List<Book> bookList = bookMapper.searchBookByName(getGoodsListByConditionRequest.getBook());
            if(!bookList.isEmpty()){
                for(Book e:bookList){
                    SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.BOOK.getName(),e.getId(),e.getName(),e.getWriter(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                    searchGoodsList.add(searchGoods);
                }
            }
        }else if(getGoodsListByConditionRequest.getClass_online()!=null){
            List<ClassOnline> classOnlineList = classOnlineMapper.searchClassOnlineByName(getGoodsListByConditionRequest.getClass_online());
            if(!classOnlineList.isEmpty()){
                for(ClassOnline e:classOnlineList){
                    SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.CLASS_ONLINE.getName(),e.getId(),e.getName(),e.getLecturer(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                    searchGoodsList.add(searchGoods);
                }
            }
        }else if(getGoodsListByConditionRequest.getClass_offline()!=null){
            List<ClassOffline> classOfflineList = classOfflineMapper.searchClassOfflineByName(getGoodsListByConditionRequest.getClass_offline());
            if(!classOfflineList.isEmpty())
            for(ClassOffline e:classOfflineList){
                SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.CLASS_OFFLINE.getName(),e.getId(),e.getName(),e.getAddress(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                searchGoodsList.add(searchGoods);
            }
        }else if(getGoodsListByConditionRequest.getDeveloper()!=null){
            List<Book> bookList = bookMapper.searchBookByWriter(getGoodsListByConditionRequest.getDeveloper());
            if(!bookList.isEmpty())
            for(Book e:bookList){
                SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.BOOK.getName(),e.getId(),e.getName(),e.getWriter(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                searchGoodsList.add(searchGoods);
            }
            List<ClassOnline> classOnlineList = classOnlineMapper.searchClassOnlineByLecturer(getGoodsListByConditionRequest.getDeveloper());
            if ((!classOnlineList.isEmpty()))
            for(ClassOnline e:classOnlineList){
                SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.CLASS_ONLINE.getName(),e.getId(),e.getName(),e.getLecturer(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                searchGoodsList.add(searchGoods);
            }
            List<ClassOffline> classOfflineList = classOfflineMapper.searchClassOfflineByAddress(getGoodsListByConditionRequest.getDeveloper());
            if (!classOfflineList.isEmpty())
            for(ClassOffline e:classOfflineList){
                SearchGoods searchGoods = new SearchGoods(CommodityObjectTypeEnum.CLASS_OFFLINE.getName(),e.getId(),e.getName(),e.getAddress(),e.getPic(),e.getPrice(),e.getLikes(),e.getBrowse());
                searchGoodsList.add(searchGoods);
            }
        }
        return new Page(new PageInfo<>(searchGoodsList));
    }

}
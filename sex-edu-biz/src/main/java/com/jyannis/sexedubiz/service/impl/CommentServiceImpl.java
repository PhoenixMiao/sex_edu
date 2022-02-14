package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.CommentService;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.ShoppingCart.Goods;
import com.jyannis.sexeducommon.dto.ShoppingCart.SimpleGoods;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.request.GiveCommentRequest;
import com.jyannis.sexeducommon.request.PageParamRequest;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private PayedGoodsMapper payedGoodsMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ClassOfflineMapper classOfflineMapper;

    @Autowired
    private ClassOnlineMapper classOnlineMapper;

    @Override
    public void giveComment(Long user_id, GiveCommentRequest giveCommentRequest){
        String create_time = TimeUtil.getCurrentTimestamp();
        commentMapper.giveComment(user_id,giveCommentRequest.getObject_type(), giveCommentRequest.getObject_id(), giveCommentRequest.getStar(),create_time,giveCommentRequest.getContents());
    }

    @Override
    public void giveLike(Long id){
        int likes = commentMapper.getLikes(id);
        commentMapper.giveLike(likes+1,id);
    }

    @Override
    public Page<Goods> getUncommentedGoodsList(Long user_id, PageParamRequest request){
        List<SimpleGoods> commentedGoods = commentMapper.getCommentedGoodsList(user_id);
        List<SimpleGoods> payedGoods = payedGoodsMapper.getPayedGoodsList(user_id);
        List<Goods> uncommentedGoods = new ArrayList<>();
        for(SimpleGoods a:payedGoods){
            boolean flag = false;
            for(SimpleGoods b:commentedGoods){
                if(a.getGoods_type().equals(b.getGoods_type()) && a.getGoods_id()==b.getGoods_id()){
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                if (a.getGoods_type().equals(CommodityObjectTypeEnum.BOOK.getName())) {
                    Book book = bookMapper.getBookById(a.getGoods_id());
                    Goods goods = new Goods(a.getGoods_type(), book.getId(), book.getName(), book.getWriter(), book.getPic(), book.getPrice());
                    uncommentedGoods.add(goods);
                } else if (a.getGoods_type().equals(CommodityObjectTypeEnum.CLASS_ONLINE.getName())) {
                    ClassOnline classOnline = classOnlineMapper.getClassOnlineById(a.getGoods_id());
                    Goods goods = new Goods(a.getGoods_type(), classOnline.getId(), classOnline.getName(), classOnline.getLecturer(), classOnline.getPic(), classOnline.getPrice());
                    uncommentedGoods.add(goods);
                } else if (a.getGoods_type().equals(CommodityObjectTypeEnum.CLASS_OFFLINE.getName())) {
                    ClassOffline classOffline = classOfflineMapper.getClassOfflineById(a.getGoods_id());
                    Goods goods = new Goods(a.getGoods_type(), classOffline.getId(), classOffline.getName(), classOffline.getLecturer(), classOffline.getPic(), classOffline.getPrice());
                    uncommentedGoods.add(goods);
                }
            }
        }
        PageParam pageParam = request.getPageParam();
        //pageParam.setOrderBy("create_time");
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
        return new Page(new PageInfo<>(uncommentedGoods));
    }
}

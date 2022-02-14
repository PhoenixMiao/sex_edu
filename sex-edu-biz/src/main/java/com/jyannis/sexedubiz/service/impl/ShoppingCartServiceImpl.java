package com.jyannis.sexedubiz.service.impl;

import com.jyannis.sexedubiz.service.ShoppingCartService;
import com.jyannis.sexeducommon.dto.ShoppingCart.BookGoods;
import com.jyannis.sexeducommon.dto.ShoppingCart.BriefGoods;
import com.jyannis.sexeducommon.dto.ShoppingCart.CartGoods;
import com.jyannis.sexeducommon.dto.ShoppingCart.Goods;
import com.jyannis.sexeducommon.entity.Book;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.request.AddToCartRequest;
import com.jyannis.sexeducommon.request.NewQuantityRequest;
import com.jyannis.sexedudao.mapper.BookMapper;
import com.jyannis.sexedudao.mapper.ClassOfflineMapper;
import com.jyannis.sexedudao.mapper.ClassOnlineMapper;
import com.jyannis.sexedudao.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ClassOnlineMapper classOnlineMapper;

    @Autowired
    private ClassOfflineMapper classOfflineMapper;

    @Override
    public void addToCart(AddToCartRequest addToCartRequest,Long user_id){
        if(user_id != null) {
            shoppingCartMapper.addToCart(user_id,addToCartRequest.getGoods_type(),addToCartRequest.getGoods_id(),addToCartRequest.getGoods_quantity());
        }
    }

    @Override
    public List<CartGoods> getCart(Long user_id){
        if(user_id != null){
            List<BriefGoods> briefGoodsList = shoppingCartMapper.getCart(user_id);
            List<CartGoods> goodsList = new ArrayList<>();
            for(BriefGoods e : briefGoodsList){
                if(e.getGoods_type().equals(CommodityObjectTypeEnum.BOOK.getName())){
                    Book book = bookMapper.getBookById(e.getGoods_id());
                    BookGoods bookgoods = new BookGoods(e.getId(),e.getGoods_type(),e.getGoods_id(),book.getName(),book.getWriter(),book.getPic(),book.getPrice(),e.getGoods_quantity());
                    goodsList.add(bookgoods);
                }else if(e.getGoods_type().equals(CommodityObjectTypeEnum.CLASS_OFFLINE.getName())){
                    ClassOffline classOffline = classOfflineMapper.getClassOfflineById(e.getGoods_id());
                    CartGoods goods = new CartGoods(e.getId(),e.getGoods_type(),e.getGoods_id(),classOffline.getName(),classOffline.getAddress(),classOffline.getPic(),classOffline.getPrice());
                    goodsList.add(goods);
                }else if(e.getGoods_type().equals(CommodityObjectTypeEnum.CLASS_ONLINE.getName())){
                    ClassOnline classOnline = classOnlineMapper.getClassOnlineById(e.getGoods_id());
                    CartGoods goods = new CartGoods(e.getId(),e.getGoods_type(),e.getGoods_id(),classOnline.getName(),classOnline.getLecturer(),classOnline.getPic(),classOnline.getPrice());
                    goodsList.add(goods);
                }
            }
            return goodsList;
        }
        return null;
    }

    @Override
    public void newsQuantity(NewQuantityRequest newQuantityRequest,Long user_id){
        shoppingCartMapper.newQuantity(newQuantityRequest.getGoods_quantity(),newQuantityRequest.getId(),user_id);
    }

    @Override
    public void deleteCart(Long id,Long user_id){
        shoppingCartMapper.deleteCart(id,user_id);
    }

}

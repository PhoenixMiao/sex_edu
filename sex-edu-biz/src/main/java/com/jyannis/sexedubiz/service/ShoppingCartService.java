package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.dto.ShoppingCart.CartGoods;
import com.jyannis.sexeducommon.dto.ShoppingCart.Goods;
import com.jyannis.sexeducommon.request.AddToCartRequest;
import com.jyannis.sexeducommon.request.NewQuantityRequest;

import java.util.List;

public interface ShoppingCartService {
    void addToCart(AddToCartRequest addToCartRequest, Long user_id);
    List<CartGoods> getCart(Long user_id);
    void newsQuantity(NewQuantityRequest newQuantityRequest, Long user_id);
    void deleteCart(Long id, Long user_id);
}

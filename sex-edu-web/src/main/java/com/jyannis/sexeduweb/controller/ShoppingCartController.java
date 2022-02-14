package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.ShoppingCartService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.ShoppingCart.CartGoods;
import com.jyannis.sexeducommon.dto.ShoppingCart.Goods;
import com.jyannis.sexeducommon.request.AddToCartRequest;
import com.jyannis.sexeducommon.request.NewQuantityRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api("购物车相关操作")
@RestController
@RequestMapping("/cart")
@Validated
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private SessionUtils sessionUtils;

    @Auth
    @PostMapping("/add")
    @ApiOperation(value = "加入购物车",response = String.class)
    public Object AddToCart(@NotNull @Validated @RequestBody AddToCartRequest addToCartRequest){
        Long user_id = sessionUtils.getUserId();
        shoppingCartService.addToCart(addToCartRequest,user_id);
        return "操作成功";
    }

    @Auth
    @GetMapping("/get")
    @ApiOperation(value = "查看购物车",response = CartGoods.class)
    public Object getCart(){
        Long user_id = sessionUtils.getUserId();
        return shoppingCartService.getCart(user_id);
    }

    @Auth
    @PostMapping("/quantity")
    @ApiOperation(value = "修改购物车中的商品数量",response = String.class)
    public Object newQuantity(@NotNull @Validated @RequestBody NewQuantityRequest newQuantityRequest){
        Long user_id = sessionUtils.getUserId();
        shoppingCartService.newsQuantity(newQuantityRequest,user_id);
        return "操作成功";
    }

    @Auth
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除购物车中的商品",response = String.class)
    public Object deleteCart(@PathVariable("id") Long shoppingCartId){
        Long user_id = sessionUtils.getUserId();
        shoppingCartService.deleteCart(shoppingCartId,user_id);
        return "操作成功";
    }
}

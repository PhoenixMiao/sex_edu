package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.CommentService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.ShoppingCart.Goods;
import com.jyannis.sexeducommon.request.GiveCommentRequest;
import com.jyannis.sexeducommon.request.PageParamRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api("评价相关操作")
@RestController
@RequestMapping("/comment")
@Validated
public class CommentController {
    @Autowired
    private SessionUtils sessionUtils;

    @Autowired
    private CommentService commentService;

    @Auth
    @PostMapping("/give")
    @ApiOperation(value = "做评价",response = String.class)
    public Object giveComment(GiveCommentRequest giveCommentRequest){
        Long user_id = sessionUtils.getUserId();
        commentService.giveComment(user_id,giveCommentRequest);
        return "操作成功";
    }

    @Auth
    @PostMapping("/like/{id}")
    @ApiOperation(value = "点赞",response = String.class)
    public Object giveLike(@PathVariable("id")Long id){
        commentService.giveLike(id);
        return "操作成功";
    }

    @Auth
    @GetMapping("/uncomment")
    @ApiOperation(value = "获取未评价商品",response = Goods.class)
    public Object getUncommentedGoodsList(@NotNull @Validated @RequestBody PageParamRequest pageParamRequest){
        return commentService.getUncommentedGoodsList(sessionUtils.getUserId(), pageParamRequest);
    }

}

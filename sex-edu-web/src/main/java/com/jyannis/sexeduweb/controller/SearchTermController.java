package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.SearchTermService;
import com.jyannis.sexeducommon.dto.SearchGoods;
import com.jyannis.sexeducommon.request.GetGoodsListByConditionRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api("搜索相关操作")
@RestController
@RequestMapping("/search")
@Validated
public class SearchTermController {

    @Autowired
    private SearchTermService searchTermService;

    @PostMapping("/condition")
    @ApiOperation(value = "根据条件搜索商品", response = SearchGoods.class)
    public Object getGoodsListByCondition(@NotNull @Valid @RequestBody GetGoodsListByConditionRequest getGoodsListByConditionRequest){
        return searchTermService.getGoodsListByCondition(getGoodsListByConditionRequest);
    }

    @GetMapping("/default")
    @ApiOperation(value = "搜索商品时提供的默认搜索项",response = String.class)
    public Object getLabelWhenSearching(){

        String[] labels = new String[]{
                "了解性教育",
                "我到底怎么了",
                "我从哪里来",
                "青春期性教育",
                "成长与性",
                "我宝贵的身体",
                "你从哪里来，我的朋友",
                "男孩女孩的第1本身体书"
        };
        return labels;
    }
}

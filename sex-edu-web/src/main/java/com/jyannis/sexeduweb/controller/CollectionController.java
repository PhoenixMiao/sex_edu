package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.CollectionService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.collection.BriefCollection;
import com.jyannis.sexeducommon.request.AddToCollectionRequest;
import com.jyannis.sexeducommon.request.GetCollectionRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api("收藏相关操作")
@RestController
@RequestMapping("/collection")
@Validated
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @Autowired
    private SessionUtils sessionUtils;

    @Auth
    @PostMapping("/add")
    @ApiOperation(value = "收藏商品",response = String.class)
    public Object addToCollection(@NotNull @Valid @RequestBody AddToCollectionRequest addToCollectionRequest){
        Long user_id = sessionUtils.getUserId();
        collectionService.addToCollection(user_id,addToCollectionRequest.getType(),addToCollectionRequest.getObject_id());
        return "操作成功";
    }

    @Auth
    @PostMapping("/cancel/{id}")
    @ApiOperation(value = "取消收藏",response = String.class)
    public Object cancelCollection(@PathVariable("id")Long id){
        collectionService.cancelCollection(id);
        return "操作成功";
    }

    @Auth
    @PostMapping("/list")
    @ApiOperation(value = "查看收藏夹",response = BriefCollection.class)
    public Object getBriefCollectionList(@NotNull @Valid @RequestBody GetCollectionRequest getCollectionRequest){
        Long user_id = sessionUtils.getUserId();
        return collectionService.getBriefCollectionList(getCollectionRequest,user_id);
    }
}

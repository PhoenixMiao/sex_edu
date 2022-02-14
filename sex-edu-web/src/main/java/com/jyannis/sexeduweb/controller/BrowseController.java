package com.jyannis.sexeduweb.controller;

import com.jyannis.sexedubiz.service.BrowseService;
import com.jyannis.sexedubiz.util.SessionUtils;
import com.jyannis.sexeducommon.annotation.Auth;
import com.jyannis.sexeducommon.dto.browse.BriefBrowse;
import com.jyannis.sexeducommon.request.PageParamRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api("浏览记录相关操作")
@RestController
@RequestMapping("/browse")
@Validated
public class BrowseController {

    @Autowired
    private BrowseService browseService;

    @Autowired
    private SessionUtils sessionUtils;

    @Auth
    @PostMapping("/list")
    @ApiOperation(value="获取浏览记录列表",response = BriefBrowse.class)
    public Object getBrowseList (@NotNull @Valid @RequestBody PageParamRequest request){
        Long user_id = sessionUtils.getUserId();
        return browseService.getBrowseList(request,user_id);
    }
}

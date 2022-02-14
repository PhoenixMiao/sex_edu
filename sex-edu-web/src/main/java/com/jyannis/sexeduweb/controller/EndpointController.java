package com.jyannis.sexeduweb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("OSS相关操作")
@RestController
@RequestMapping("/endpoint")
@Validated
public class EndpointController {

    @GetMapping("/{key}")
    @ApiOperation(value = "获取阿里云OSS域名(输入“oss”时返回阿里云域名)",response = String.class)
    public Object getOSS(@PathVariable("key")String key){
        if(key.equals("oss")){
            return "https://sex-edu.oss-cn-shanghai.aliyuncs.com";
        }
        return "操作失败";
    }

    @GetMapping("/new_oss")
    @ApiOperation(value = "获取阿里云OSS域名(输入“new_oss”时返回阿里云域名)",response = String.class)
    public Object getNewOSS(){
            return "https://phoenix1975.oss-cn-shanghai.aliyuncs.com";
    }
}

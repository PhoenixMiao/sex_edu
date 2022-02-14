package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


/**
 * @author lishuai
 * @version 2021/2/2 21:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("class_offline 线下课")
public class ClassOffline {

    @Id
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("课程名")
    private String name;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("讲师")
    private String lecturer;
    @ApiModelProperty("时间")
    private String datetime;
    @ApiModelProperty("地点")
    private String address;
    @ApiModelProperty("适龄下限")
    private int age_floor;
    @ApiModelProperty("适龄上限")
    private int age_ceiling;
    @ApiModelProperty("课程子类别")
    private String sub_type;
    @ApiModelProperty("内容")
    private String content;
    @ApiModelProperty("名额")
    private int place;
    @ApiModelProperty("评论数")
    private int comment_num;
    @ApiModelProperty("发布时间")
    private String create_time;
    @ApiModelProperty("价格")
    private double price;
    @ApiModelProperty("图片")
    private String pic;
    @ApiModelProperty("点赞数")
    private int likes;
    @ApiModelProperty("浏览量")
    private int browse;
    @ApiModelProperty("课程类别")
    private String type;
}

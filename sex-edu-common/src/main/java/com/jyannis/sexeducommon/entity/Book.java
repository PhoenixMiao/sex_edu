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
@ApiModel("book 图书")
public class Book {

    @Id
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("书名")
    private String name;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("作者")
    private String writer;
    @ApiModelProperty("出版社")
    private String press;
    @ApiModelProperty("适龄下限")
    private int age_floor;
    @ApiModelProperty("适龄上限")
    private int age_ceiling;
    @ApiModelProperty("课程子类别")
    private String sub_type;
    @ApiModelProperty("评分")
    private double score;
    @ApiModelProperty("内容")
    private String content;
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
    @ApiModelProperty("类别")
    private String type;
    @ApiModelProperty("库存")
    private int stock;

}

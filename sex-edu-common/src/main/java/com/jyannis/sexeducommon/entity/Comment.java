package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Comment 评价")
public class Comment {
    @Id
    @ApiModelProperty("id")
    private Long id;
    @Id
    @ApiModelProperty("用户id")
    private Long user_id;
    @ApiModelProperty("商品类型")
    private String object_type;
    @ApiModelProperty("商品id")
    private Long object_id;
    @ApiModelProperty("星级")
    private int star;
    @ApiModelProperty("点赞数")
    private int likes;
    @ApiModelProperty("评论时间")
    private String create_time;
    @ApiModelProperty("评论内容")
    private String contents;

}

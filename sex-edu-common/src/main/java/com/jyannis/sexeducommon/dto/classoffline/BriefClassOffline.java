package com.jyannis.sexeducommon.dto.classoffline;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("BriefClassOffline 线下课程简要信息")
public class BriefClassOffline implements Serializable {

    /**
     * {@link com.jyannis.sexeducommon.entity.ClassOffline}
     */

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("课程名")
    private String name;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("适龄下限")
    private int age_floor;
    @ApiModelProperty("适龄上限")
    private int age_ceiling;
    @ApiModelProperty("图片")
    private String pic;
    @ApiModelProperty("点赞数")
    private int likes;
    @ApiModelProperty("浏览量")
    private int browse;
    @ApiModelProperty("课程子类别")
    private String subtype;
}

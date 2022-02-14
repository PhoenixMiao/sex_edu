package com.jyannis.sexeducommon.dto.browse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("BriefBrowse 简要浏览记录")
public class BriefBrowse {

    /**
     * {@link com.jyannis.sexeducommon.entity.Browse}
     */
    @ApiModelProperty("类别")
    private String type;
    @ApiModelProperty("浏览对象的id")
    private Long object_id;
    @ApiModelProperty("浏览时间")
    private String create_time;
    @ApiModelProperty("对象名称")
    private String name;
    @ApiModelProperty("对象描述")
    private String description;
    @ApiModelProperty("图片")
    private String pic;
}

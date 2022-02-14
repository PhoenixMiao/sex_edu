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
@ApiModel("NotStartedClassOffline 未开始的线下课程的简要信息")
public class NotStartedClassOffline implements Serializable {
    /**
     * {@link com.jyannis.sexeducommon.entity.ClassOffline}
     */
    @ApiModelProperty("课程名")
    private String name;
    @ApiModelProperty("图片")
    private String pic;
    @ApiModelProperty("时间")
    private String datetime;
    @ApiModelProperty("地点")
    private String address;
}

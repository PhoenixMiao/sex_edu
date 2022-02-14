package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("browse 浏览记录")
public class Browse {

    @Id
    @ApiModelProperty("id")
    private Long id;
    @Id
    @ApiModelProperty("浏览用户")
    private Long user_id;
    @ApiModelProperty("类别")
    private String type;
    @ApiModelProperty("浏览对象的id")
    private Long object_id;
    @ApiModelProperty("浏览时间")
    private String create_time;
}

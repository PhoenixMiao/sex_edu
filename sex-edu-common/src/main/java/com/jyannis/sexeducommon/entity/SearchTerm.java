package com.jyannis.sexeducommon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


/**
 * @author yannis
 * @version 2021/2/2 17:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("SearchTerm 搜索推荐")
public class SearchTerm {

    @Id
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("搜索名")
    private String name;
    @ApiModelProperty("点击量")
    private Integer hits;
}

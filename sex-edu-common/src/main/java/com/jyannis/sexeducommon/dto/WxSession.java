package com.jyannis.sexeducommon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yannis
 * @version 2020/11/6 21:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WxSession {

    private String openid;
    private String session_key;
    private String unionid;
    private Integer errcode;
    private String errmsg;

}

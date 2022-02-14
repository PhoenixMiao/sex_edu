package com.jyannis.sexeducommon.dto.wxpay;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通知数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("WxPayPlaceOrderNotifyResponse 微信支付-支付回调通知资源数据")
public class WxPayPlaceOrderNotifyResponse implements Serializable {
  private static final long serialVersionUID = 341873114458149365L;
  private String id;

  private String create_time;

  private String event_type;

  private String resource_type;

  private Resource resource;

  private String summary;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @ApiModel("Resource 微信支付-支付回调-")
  public static class Resource implements Serializable {

    private String algorithm;

    private String ciphertext;

    private String associated_data;

    private String nonce;
  }

}

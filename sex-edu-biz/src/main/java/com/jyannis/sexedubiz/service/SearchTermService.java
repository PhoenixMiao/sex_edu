package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.dto.SearchGoods;
import com.jyannis.sexeducommon.request.GetGoodsListByConditionRequest;

public interface SearchTermService {
    Page<SearchGoods> getGoodsListByCondition(GetGoodsListByConditionRequest getGoodsListByConditionRequest);
}

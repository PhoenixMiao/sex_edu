package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.ShoppingCart.Goods;
import com.jyannis.sexeducommon.request.GiveCommentRequest;
import com.jyannis.sexeducommon.request.PageParamRequest;

public interface CommentService {
    void giveComment(Long user_id, GiveCommentRequest giveCommentRequest);
    void giveLike(Long id);
    Page<Goods> getUncommentedGoodsList(Long user_id, PageParamRequest request);
}

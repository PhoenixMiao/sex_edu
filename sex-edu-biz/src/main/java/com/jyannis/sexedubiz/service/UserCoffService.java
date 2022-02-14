package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.dto.classoffline.NotStartedClassOffline;
import com.jyannis.sexeducommon.entity.PayedGoods;
import com.jyannis.sexeducommon.request.PageParamRequest;

public interface UserCoffService {
    void signUpForClassOfflinePaying(Long user_id, Long class_offline_id);
    PayedGoods signUpForClassOfflinePayed(PayedGoods payedGoods);
    void cancelClassOnline(Long id);
    Page<NotStartedClassOffline> getNotStartedClassOfflineByUserId(Long user_id, PageParamRequest pageParamRequest);
}

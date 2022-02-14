package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.entity.PayedGoods;

public interface UserConService {
    void buyClassOnlinePaying(Long user_id, Long class_online_id);
    PayedGoods buyClassOnlinePayed(PayedGoods payedGoods);
}

package com.jyannis.sexedubiz.service.impl;

import com.jyannis.sexedubiz.service.UserConService;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexeducommon.entity.PayedGoods;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.util.JsonUtil;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.ClassOnlineMapper;
import com.jyannis.sexedudao.mapper.PayedGoodsMapper;
import com.jyannis.sexedudao.mapper.UserConMapper;
import com.jyannis.sexeduthirdparty.service.WxPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class UserConServiceImpl implements UserConService {
    @Autowired
    private UserConMapper userConMapper;

    @Autowired
    private ClassOnlineMapper classOnlineMapper;

    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private PayedGoodsMapper payedGoodsMapper;

    @Override
    public void buyClassOnlinePaying(Long user_id,Long class_online_id){
        if(user_id!=null){
            ClassOnline classOnline = classOnlineMapper.getClassOnlineById(class_online_id);
            String create_time = TimeUtil.getCurrentTimestamp();
            PayedGoods payedGoods = new PayedGoods(null,user_id, CommodityObjectTypeEnum.CLASS_ONLINE.getName(),class_online_id,(int)(1000*classOnline.getPrice()),create_time);
            wxPayService.placeOrder(user_id, JsonUtil.toJSONString(payedGoods),"/wx/notify", payedGoods.getPrice());
//            userConMapper.buyClassOnline(user_id,class_online_id,create_time);
        }
    }

    @Override
    public PayedGoods buyClassOnlinePayed(PayedGoods payedGoods){
        userConMapper.buyClassOnline(payedGoods.getUser_id(),payedGoods.getObject_id(),payedGoods.getCreate_time());
        payedGoodsMapper.addPayedGoods(payedGoods.getUser_id(),payedGoods.getObject_type(),payedGoods.getObject_id(),payedGoods.getPrice(),payedGoods.getCreate_time());
        return payedGoods;
    }
}

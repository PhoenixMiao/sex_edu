package com.jyannis.sexedubiz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyannis.sexedubiz.service.UserCoffService;
import com.jyannis.sexeducommon.common.Page;
import com.jyannis.sexeducommon.common.PageParam;
import com.jyannis.sexeducommon.dto.classoffline.NotStartedClassOffline;
import com.jyannis.sexeducommon.entity.ClassOffline;
import com.jyannis.sexeducommon.entity.PayedGoods;
import com.jyannis.sexeducommon.entity.UserCoff;
import com.jyannis.sexeducommon.enums.CommodityObjectTypeEnum;
import com.jyannis.sexeducommon.request.PageParamRequest;
import com.jyannis.sexeducommon.util.JsonUtil;
import com.jyannis.sexeducommon.util.TimeUtil;
import com.jyannis.sexedudao.mapper.ClassOfflineMapper;
import com.jyannis.sexedudao.mapper.PayedGoodsMapper;
import com.jyannis.sexedudao.mapper.UserCoffMapper;
import com.jyannis.sexeduthirdparty.service.WxPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCoffServiceImpl implements UserCoffService {
    @Autowired
    private ClassOfflineMapper classOfflineMapper;

    @Autowired
    private UserCoffMapper userCoffMapper;

    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private PayedGoodsMapper payedGoodsMapper;

    @Override
    public void signUpForClassOfflinePaying(Long user_id,Long class_offline_id){
        if(user_id!=null) {
            ClassOffline classOffline = classOfflineMapper.getClassOfflineById(class_offline_id);
            String create_time = TimeUtil.getCurrentTimestamp();
            PayedGoods payedGoods = new PayedGoods(null,user_id, CommodityObjectTypeEnum.CLASS_OFFLINE.getName(), classOffline.getId(),(int)(1000*classOffline.getPrice()),create_time);
            wxPayService.placeOrder(user_id, JsonUtil.toJSONString(payedGoods),"/wx/notify",payedGoods.getPrice());
     //       userCoffMapper.signUpForClassOnline(user_id, class_offline_id, create_time);
        }
    }

    @Override
    public PayedGoods signUpForClassOfflinePayed(PayedGoods payedGoods){
        userCoffMapper.signUpForClassOnline(payedGoods.getUser_id(),payedGoods.getObject_id(),payedGoods.getCreate_time());
        payedGoodsMapper.addPayedGoods(payedGoods.getUser_id(),payedGoods.getObject_type(),payedGoods.getObject_id(),payedGoods.getPrice(), payedGoods.getCreate_time());
        return payedGoods;
    }

    @Override
    public void cancelClassOnline(Long id){
        userCoffMapper.cancelClassOnline(id);
    }

    @Override
    public Page<NotStartedClassOffline> getNotStartedClassOfflineByUserId(Long user_id, PageParamRequest pageParamRequest){
        List<UserCoff> userCoffList = userCoffMapper.getUserCoffListByUserId(user_id);
        List<NotStartedClassOffline> notStartedClassOfflineList = new ArrayList<>();
        for(UserCoff e :userCoffList){
            ClassOffline classOffline = classOfflineMapper.getClassOfflineById(e.getClass_offline_id());
            String create_time = TimeUtil.getCurrentTimestamp();
            if(classOffline.getDatetime().compareTo(create_time)>=0) {
                NotStartedClassOffline notStartedClassOffline = new NotStartedClassOffline(classOffline.getName(), classOffline.getPic(), classOffline.getDatetime(), classOffline.getAddress());
                notStartedClassOfflineList.add(notStartedClassOffline);
            }
        }
        if(pageParamRequest == null) return null;
        PageParam pageParam = pageParamRequest.getPageParam();
        //pageParam.setOrderBy("create_time");
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize(),pageParam.getOrderBy());
        return new Page(new PageInfo<>(notStartedClassOfflineList));
    }
}

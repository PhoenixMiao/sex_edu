package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.ShoppingCart.SimpleGoods;
import com.jyannis.sexeducommon.entity.PayedGoods;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PayedGoodsMapper extends MyMapper<PayedGoods> {
    @Insert("INSERT INTO payed_goods VALUES (null,#{user_id},#{object_type},#{object_id},#{price},#{create_time});")
    void addPayedGoods(@Param("user_id")Long user_id,
                       @Param("object_type")String object_type,
                       @Param("object_id")Long object_id,
                       @Param("price")int price,
                       @Param("create_time")String create_time);

    @Select("SELECT object_type,object_id FROM payed_goods WHERE user_id = #{user_id};")
    List<SimpleGoods> getPayedGoodsList(@Param("user_id")Long user_id);
}

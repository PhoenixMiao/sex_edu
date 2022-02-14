package com.jyannis.sexedudao.mapper;

import com.jyannis.sexeducommon.dto.ShoppingCart.BriefGoods;
import com.jyannis.sexeducommon.entity.ClassOnline;
import com.jyannis.sexedudao.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShoppingCartMapper extends MyMapper<ClassOnline> {

    @Insert("INSERT INTO shopping_cart VALUES (null,#{user_id},#{goods_type},#{goods_id},#{goods_quantity});")
    int addToCart(@Param("user_id") Long user_id,
                  @Param("goods_type") String goods_type,
                  @Param("goods_id") Long goods_id,
                  @Param("goods_quantity") int goods_quantity);

    @Select("SELECT id,goods_type,goods_id,goods_quantity FROM shopping_cart WHERE user_id =#{user_id}")
    List<BriefGoods> getCart(@Param("user_id") Long user_id);

    @Update("UPDATE shopping_cart SET goods_quantity = #{goods_quantity} WHERE id = #{id} AND user_id = #{user_id}")
    void newQuantity(@Param("goods_quantity") int goods_quantity,
                     @Param("id") Long id,
                     @Param("user_id") Long user_id);

    @Delete("DELETE FROM shopping_cart WHERE id=#{id} AND user_id=#{user_id}")
    void deleteCart(@Param("id") Long id,
                    @Param("user_id") Long user_id);
}

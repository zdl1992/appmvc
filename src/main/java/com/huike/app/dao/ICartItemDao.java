package com.huike.app.dao;

import com.huike.app.bean.CartItem;
import com.huike.app.bean.Caterory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zero on 2017/7/27.
 */
public interface ICartItemDao {
    CartItem queryCartItemByUidAndBid(@Param("cartItem") CartItem cartItem);
    int insertCartItem(@Param("cartItem") CartItem cartItem);
    int updateQuantityByUidAndBid(@Param("cartItem") CartItem cartItem);
    List<CartItem> queryCartItemsByUid(@Param("uid") String uid);

    int delectCartItems(@Param("cartItemIds") String cartItemIds);

    int delectListCatItem(@Param("cartItemIds") String[] cartItemIds);

    List<CartItem> queryListCarItem(@Param("cartItemIds") String[] i);
}

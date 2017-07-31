package com.huike.app.servieces;

import com.huike.app.bean.CartItem;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * Created by Zero on 2017/7/27.
 */
public interface ICartItemServices {

    void AddICartItem(CartItem cartItem);

    List<CartItem> queryCartItemsByUid(String uid);

    void delectCartItem(String id);

    void delectlistCarItem(String[] i);

    List<CartItem> querylistCarItem(String[] i);
}

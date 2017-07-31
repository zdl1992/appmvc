package com.huike.app.servieces.impl;

import com.huike.app.bean.CartItem;
import com.huike.app.dao.ICartItemDao;
import com.huike.app.servieces.ICartItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Zero on 2017/7/27.
 */
@Service
public class CartItemServicesimpl implements ICartItemServices{
    @Autowired
    private ICartItemDao iCartItemDao;

    @Override
    public void AddICartItem(CartItem cartItem) {
        if (cartItem.getUid()!=null && cartItem.getBid()!=null){
            CartItem cartItemResult= iCartItemDao.queryCartItemByUidAndBid(cartItem);
            if (cartItemResult==null){
                cartItem.setCartItemId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
                iCartItemDao.insertCartItem(cartItem);
            }else {
                iCartItemDao.updateQuantityByUidAndBid(cartItem);
            }
        }
    }

    @Override
    public List<CartItem> queryCartItemsByUid(String uid) {
        return iCartItemDao.queryCartItemsByUid(uid);
    }

    @Override
    public void delectCartItem(String id) {
        iCartItemDao.delectCartItems(id);
    }

    @Override
    public void delectlistCarItem(String[] i) {
       iCartItemDao.delectListCatItem(i);
    }

    @Override
    public List<CartItem> querylistCarItem(String[] i) {
        return iCartItemDao.queryListCarItem(i);
    }
}
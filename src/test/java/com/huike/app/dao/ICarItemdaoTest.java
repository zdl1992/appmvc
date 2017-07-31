package com.huike.app.dao;

import com.huike.app.bean.CartItem;
import com.huike.app.bean.Caterory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author dhc
 * @version V1.0
 * @date 17/7/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ICarItemdaoTest {
    @Autowired
  private ICartItemDao iCartItemDao;

    @Test
    public void testListAll() throws Exception {
        CartItem cartItem=new CartItem();
        cartItem.setUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        cartItem.setBid("000A18FDB38F470DBE9CD0972BADB23F");
       CartItem list =  iCartItemDao.queryCartItemByUidAndBid(cartItem);
        System.out.println(list.toString());
    }

    @Test
    public void testinsertCartItem() throws Exception {
        CartItem cartItem=new CartItem();
        cartItem.setUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        cartItem.setBid("000A18FDB38F470DBE9CD0972BADB23F");
        cartItem.setQuantity(22);
        cartItem.setCartItemId( UUID.randomUUID().toString().replace("-", "").toUpperCase());
        int i =  iCartItemDao.insertCartItem(cartItem);
        System.out.println(i);
    }


    @Test
    public void getbyidCartItem() throws Exception {
        List<CartItem> items=  iCartItemDao.queryCartItemsByUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        System.out.println(items);
    }

    @Test
    public void testDelectListCatItem() throws Exception {
        String[] a = {"6A89A4CBBEDD42EBB33E80F86556ED19","628D3278FDE04ACFBEBB2565BF50F8FE"};
        iCartItemDao.delectListCatItem(a);

    }

    @Test
    public void testquderListCatItem() throws Exception {
        String[] a = {"073BD2C593AB454BB483E63D766A2CDF","0FB2A0F3BA294305B6180A5B5D6E26E5"};
        List<CartItem> list=iCartItemDao.queryListCarItem(a);
        System.out.println(list);

    }
}
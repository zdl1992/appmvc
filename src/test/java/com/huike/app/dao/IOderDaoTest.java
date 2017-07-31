package com.huike.app.dao;

import com.huike.app.bean.OrderBean;
import com.huike.app.bean.OrderItemBean;
import com.huike.app.utils.DatetimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Zero on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class IOderDaoTest {
    @Autowired
    private IOderDao dao;
    @Test
    public void testGetListOrder() throws Exception {
        List<OrderBean> listOrder= dao.getListOrder("11EDBA1AA83E4F8D95EE0B42196770C0",0,8);
        System.out.println(listOrder);
    }

    @Test
    public void testGetcountOrderItem() throws Exception {
      int i=  dao.getcountOrder("11EDBA1AA83E4F8D95EE0B42196770C0");
        System.out.println(i);
    }

    @Test
    public void testAddOrder() throws Exception {;
        try {
            OrderBean bean= new OrderBean();
            bean.setOid("2");
            bean.setOrdertime(DatetimeUtil.getnewDate());
            bean.setStatus("4");
            bean.setAddress("sssssss");
            bean.setTotal(44);
            bean.setUid("11EDBA1AA83E4F8D95EE0B42196770C0");
            dao.addOrder(bean);
        }catch (Exception e){
           e.printStackTrace();
        }


    }
}
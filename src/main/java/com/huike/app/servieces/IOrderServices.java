package com.huike.app.servieces;

import com.huike.app.bean.OrderBean;
import com.huike.tools.commons.PageBean;

import java.util.List;

/**
 * Created by Zero on 2017/7/29.
 */

public interface IOrderServices {

    List<OrderBean> getListOrder(String uid,PageBean<OrderBean> pd);

    int countOrderItem(String s);

    int addOrderBooks(OrderBean orderBean);
}

package com.huike.app.servieces.impl;

import com.huike.app.bean.OrderBean;
import com.huike.app.dao.IOderDao;
import com.huike.app.servieces.IOrderServices;
import com.huike.app.utils.DatetimeUtil;
import com.huike.tools.commons.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zero on 2017/7/29.
 */
@Service
public class OrderServicesimpl implements IOrderServices{
    @Autowired
    private IOderDao dao;

    @Override
    public List<OrderBean> getListOrder(String uid,PageBean<OrderBean> pd) {
        int size=pd.getPageSize();
        int start=(pd.getPageNumber()-1)*size;
        return dao.getListOrder(uid,start,size);
    }

    @Override
    public int countOrderItem(String s) {
        return dao.getcountOrder(s);
    }

    @Override
    public int addOrderBooks(OrderBean orderBean) {
        orderBean.setStatus("1");
        orderBean.setOrdertime(DatetimeUtil.getnewDate());
        orderBean.setOid(DatetimeUtil.getUUid());
        return dao.addOrder(orderBean);
    }
}

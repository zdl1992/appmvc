package com.huike.app.dao;

import com.huike.app.bean.OrderBean;
import com.huike.app.bean.OrderItemBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zero on 2017/7/29.
 */
public interface IOderDao {
    List<OrderBean> getListOrder(@Param("uid") String uid,@Param("start")int start,@Param("size") int size);

    int getcountOrder(@Param("s")String s);

    int addOrder(@Param("orderBean")OrderBean orderBean);
}

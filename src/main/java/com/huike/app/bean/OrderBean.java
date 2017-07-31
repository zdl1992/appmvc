package com.huike.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zero on 2017/7/29.
 */
public class OrderBean {
    private String oid;
    private Date ordertime;
    private int total;
    private String status;
    private String address;
    private String uid;
    private List<OrderItemBean> orderItemBeans=new ArrayList<OrderItemBean>();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<OrderItemBean> getOrderItemBeans() {
        return orderItemBeans;
    }

    public void setOrderItemBeans(List<OrderItemBean> orderItemBeans) {
        this.orderItemBeans = orderItemBeans;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "oid='" + oid + '\'' +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", uid='" + uid + '\'' +
                ", orderItemBeans=" + orderItemBeans +
                '}';
    }
}

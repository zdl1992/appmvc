package com.huike.app.bean;

/**
 * Created by Zero on 2017/7/29.
 */
public class OrderItemBean {
    private String orderItemId;
    private String quantity;
    private String subtotal;
    private String bid;
    private String bname;
    private String currPrice;
    private String image_b;
    private String oid;
    public String getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
    public String getBid() {
        return bid;
    }
    public void setBid(String bid) {
        this.bid = bid;
    }
    public String getBname() {
        return bname;
    }
    public void setBname(String bname) {
        this.bname = bname;
    }
    public String getCurrPrice() {
        return currPrice;
    }
    public void setCurrPrice(String currPrice) {
        this.currPrice = currPrice;
    }
    public String getImage_b() {
        return image_b;
    }
    public void setImage_b(String image_b) {
        this.image_b = image_b;
    }
    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "OrderItemBean{" +
                "orderItemId='" + orderItemId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", subtotal='" + subtotal + '\'' +
                ", bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", currPrice='" + currPrice + '\'' +
                ", image_b='" + image_b + '\'' +
                ", oid='" + oid + '\'' +
                '}';
    }
}

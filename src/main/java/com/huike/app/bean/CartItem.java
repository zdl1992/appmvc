package com.huike.app.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Zero on 2017/7/27.
 */
public class CartItem {
    private String cartItemId;
    private Integer quantity;//购物车中一种图书的数量
    private String bid;//图书的主键
    private String uid;
    private String orderBy;
    private Book book;
    private double subTotal;

    public double getSubTotal() {
        BigDecimal quantityBigDecimal = new BigDecimal(quantity+"");
        BigDecimal currpriceBigDecimal = new BigDecimal(book.getCurrPrice()+"");
        BigDecimal result = quantityBigDecimal.multiply(currpriceBigDecimal);
        return result.doubleValue();
    }


    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", quantity=" + quantity +
                ", bid='" + bid + '\'' +
                ", uid='" + uid + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", books=" + book +
                '}';
    }
}

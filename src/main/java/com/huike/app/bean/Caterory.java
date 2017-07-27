package com.huike.app.bean;

import java.util.List;

/**
 * Created by Zero on 2017/7/22.
 */
public class Caterory {
    private String cid;
    private String cname;
    private String desc;
    private String pid;
    private String orderBy;

    private boolean open;
    private String url;
    private String target;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Caterory{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", desc='" + desc + '\'' +
                ", pid=" + pid +
                ", orderBy='" + orderBy + '\'' +
                ", open=" + open +
                ", url='" + url + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}

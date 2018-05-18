package com.yisutech.corp.domain.repository.pojo;

import java.util.Date;

public class WxExchangeProduct {
    private Integer id;

    private String prodNumber;

    private String title;

    private Integer stock;

    private Integer status;

    private Date validTime;

    private Date expireTime;

    private String prodPic;

    private String desc;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer needScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdNumber() {
        return prodNumber;
    }

    public void setProdNumber(String prodNumber) {
        this.prodNumber = prodNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getProdPic() {
        return prodPic;
    }

    public void setProdPic(String prodPic) {
        this.prodPic = prodPic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getNeedScore() {
        return needScore;
    }

    public void setNeedScore(Integer needScore) {
        this.needScore = needScore;
    }
}
package com.yisutech.corp.domain.repository.pojo;

import java.util.Date;

public class WxBuyRecord {
    private Integer id;

    private String unionId;

    private String openId;

    private Integer prodId;

    private String prodSn;

    private Date gmtCreate;

    private Integer faceAmout;

    private String faceUnit;

    private String buyType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdSn() {
        return prodSn;
    }

    public void setProdSn(String prodSn) {
        this.prodSn = prodSn;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getFaceAmout() {
        return faceAmout;
    }

    public void setFaceAmout(Integer faceAmout) {
        this.faceAmout = faceAmout;
    }

    public String getFaceUnit() {
        return faceUnit;
    }

    public void setFaceUnit(String faceUnit) {
        this.faceUnit = faceUnit;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }
}
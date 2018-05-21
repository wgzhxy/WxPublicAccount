package com.yisutech.corp.domain.repository.pojo;

import java.util.Date;

public class WxVefifyCode {
    private Integer id;

    private String moble;

    private String openId;

    private String vefifyCode;

    private String unionId;

    private String appId;

    private Date gmtModify;

    private Date gmtCreate;

    private Date validTimeStamp;

    private Date expireTimeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoble() {
        return moble;
    }

    public void setMoble(String moble) {
        this.moble = moble;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getVefifyCode() {
        return vefifyCode;
    }

    public void setVefifyCode(String vefifyCode) {
        this.vefifyCode = vefifyCode;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getValidTimeStamp() {
        return validTimeStamp;
    }

    public void setValidTimeStamp(Date validTimeStamp) {
        this.validTimeStamp = validTimeStamp;
    }

    public Date getExpireTimeStamp() {
        return expireTimeStamp;
    }

    public void setExpireTimeStamp(Date expireTimeStamp) {
        this.expireTimeStamp = expireTimeStamp;
    }
}
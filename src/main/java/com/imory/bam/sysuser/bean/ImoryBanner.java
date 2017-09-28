package com.imory.bam.sysuser.bean;

import java.util.Date;

public class ImoryBanner {

    private String uid;                         //Id
    
    private String bannerImg;                    //图片地址
    
    private String bannerUrl;                    //点击图片跳转的链接地址
    
    private Integer state;                       // 1:正常显示,2:隐藏
    
    private String operatorId;                   //操作员uid
    
    private Date createTime;                     //上传时间

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
}

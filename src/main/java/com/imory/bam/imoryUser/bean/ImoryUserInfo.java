package com.imory.bam.imoryUser.bean;

import java.util.Date;

public class ImoryUserInfo {

    private String uid;                            //主键
    
    private String username;                       //用户名
    
    private String password;                       //密码
    
    private String nickName;                       //昵称
    
    private String mobile;                         //手机号
    
    private String openId;                         //微信openId
    
    private String unionId;                        //微信unionId
    
    private Integer level;                         //1为普通会员用户，2为实名认证用户
    
    private Integer state;                         //用户状态:1正常,2锁定
    
    private String avatar;                         //头像
    
    private String avatar_small;                   //小头像
    
    private String email;                          //邮箱
    
    private String wxSubscribe;                    //是否关注
    
    private Date reg_time;                       //注册时间
    
    private Date last_login_time;                //最后一次登录时间

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_small() {
        return avatar_small;
    }

    public void setAvatar_small(String avatar_small) {
        this.avatar_small = avatar_small;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWxSubscribe() {
        return wxSubscribe;
    }

    public void setWxSubscribe(String wxSubscribe) {
        this.wxSubscribe = wxSubscribe;
    }

    public Date getReg_time() {
        return reg_time;        
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }
    
}

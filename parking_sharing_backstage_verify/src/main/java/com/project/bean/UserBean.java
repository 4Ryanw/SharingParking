package com.project.bean;

import java.io.Serializable;

/**
 * 用户类
 * 
 * @author YuChen
 *
 */
public class UserBean implements Serializable {

    private static final long serialVersionUID = 6464763142392261668L;
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 实名
     */
    private String realname;
    private String password;
    private String address;
    private String phone;
    /**
     * 身份证号
     */
    private String idcard;
    private String email;
    /**
     * 职业
     */
    private String job;
    /**
     * 头像图片名
     */
    private String headImg;

    @Override
    public String toString() {
        return "UserBean [id=" + id + ", username=" + username + ", realname=" + realname + ", password=" + password
                + ", address=" + address + ", phone=" + phone + ", idcard=" + idcard + ", email=" + email + ", job="
                + job + ", headImg=" + headImg + "]";
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}

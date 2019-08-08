package com.project.bean;

import java.io.Serializable;

/**
 * 车位实体类
 * 
 * @author YuChen
 *
 */
public class CarPortBean implements Serializable {
    private static final long serialVersionUID = -7780492394766183143L;
    private int id;
    /**
     * 车位地址
     */
    private String address;
    /**
     * 车库内的编号
     */
    private String number;
    /**
     * 车位主人
     */
    private UserBean userBean;
    /**
     * 车位产权证图片
     */
    private String certificate;
    /**
     * 车位产权证号
     */
    private String certificateNumber;
    /**
     * 车位审核状态
     */
    private String status;
    /**
     * 车位添加时间
     */
    private String createTime;

    @Override
    public String toString() {
        return "CarPortBean [id=" + id + ", address=" + address + ", number=" + number + ", userBean=" + userBean
                + ", certificate=" + certificate + ", certificateNumber=" + certificateNumber + ", status=" + status
                + ", createTime=" + createTime + "]";
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

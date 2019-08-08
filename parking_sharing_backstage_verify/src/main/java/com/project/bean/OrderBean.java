package com.project.bean;

import java.io.Serializable;

/**
 * 订单实体类
 * 
 * @author YuChen
 *
 */
public class OrderBean implements Serializable {
    private static final long serialVersionUID = 3031092922186203117L;
    private int id;
    /**
     * 订单开始时间
     */
    private String beginTime;
    /**
     * 订单退订时间
     */
    private String endTime;
    /**
     * 订单价格
     */
    private int status;
    /**
     * 订单总价
     */
    private double price;
    /**
     * 留言
     */
    private String words;
    /**
     * 订单内车位对象
     */
    private CarPortBean carPortBean;
    /**
     * 抢租客对象
     */
    private UserBean user;

    @Override
    public String toString() {
        return "OrderBean [id=" + id + ", beginTime=" + beginTime + ", endTime=" + endTime + ", status=" + status
                + ", price=" + price + ", words=" + words + ", carPortBean=" + carPortBean + ", user=" + user + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public CarPortBean getCarPortBean() {
        return carPortBean;
    }

    public void setCarPortBean(CarPortBean carPortBean) {
        this.carPortBean = carPortBean;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

}

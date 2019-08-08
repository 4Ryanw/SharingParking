package com.project.bean;

import java.io.Serializable;

/**
 * 投诉实体类
 * 
 * @author YuChen
 *
 */
public class ComplainBean implements Serializable {
    private static final long serialVersionUID = 1090268317431299845L;
    /**
     * 投诉记录id
     */
    private int id;
    /**
     * 投诉用户对象
     */
    private UserBean tuUser;
    /**
     * 被投诉用户对象
     */
    private UserBean btuUser;
    /**
     * 投诉详情
     */
    private String content;
    /**
     * 投诉图片
     */
    private String img;
    /**
     * 投诉处理状态
     */
    private int status;
    /**
     * 租车位订单id
     */
    private int orderId;
    /**
     * 投述创建时间
     */
    private String createTime;
    /**
     * 投诉处理时间
     */
    private String handleTime;
    /**
     * 投诉处理意见
     */
    private String result;

    @Override
    public String toString() {
        return "ComplainBean [id=" + id + ", tuUser=" + tuUser + ", btuUser=" + btuUser + ", content=" + content
                + ", img=" + img + ", status=" + status + ", orderId=" + orderId + ", createTime=" + createTime
                + ", handleTime=" + handleTime + ", result=" + result + "]";
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getHandler() {
        return handleTime;
    }

    public void setHandler(String handleTime) {
        this.handleTime = handleTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBean getTuUser() {
        return tuUser;
    }

    public void setTuUser(UserBean tuUser) {
        this.tuUser = tuUser;
    }

    public UserBean getBtuUser() {
        return btuUser;
    }

    public void setBtuUser(UserBean btuUser) {
        this.btuUser = btuUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

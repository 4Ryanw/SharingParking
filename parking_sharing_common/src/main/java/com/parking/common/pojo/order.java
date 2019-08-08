package com.parking.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class order implements Serializable {

    private Integer id;

    private Integer uid;

    private Integer rid;

    private double price;

    private Date stime;

    private Date etime;

    private int status; //订单状态

    private String words;   //订单留言
}

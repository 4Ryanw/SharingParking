package com.project.service;

import com.project.bean.OrderBean;

public interface IOrderService {
    /**
     * 通过订单id查询订单
     * 
     * @param id 订单id
     * @return
     */
    OrderBean findOrderById(int id);
}

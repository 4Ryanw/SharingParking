package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.OrderBean;
import com.project.dao.IOrderDao;
import com.project.service.IOrderService;

/**
 * 
 * @author YuChen
 *
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public OrderBean findOrderById(int id) {
        return orderDao.findOrderById(id);
    }

}

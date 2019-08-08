package com.project.dao;

import org.apache.ibatis.annotations.Mapper;

import com.project.bean.OrderBean;

/**
 * 订单持久层接口
 * 
 * @author YuChen
 *
 */
@Mapper
public interface IOrderDao {
    /**
     * 通过订单id查询订单
     * 
     * @param id 订单id
     * @return
     */
    OrderBean findOrderById(int id);
}

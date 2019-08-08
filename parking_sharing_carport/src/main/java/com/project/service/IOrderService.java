package com.project.service;

import java.util.List;

import com.project.pojo.OrderBean;
import com.project.pojo.TimeBeanDto;

public interface IOrderService {
	public OrderBean getById(int id);
	public List<OrderBean> listByOwnerID(int ownerid);
	public List<OrderBean> listByUserId(int userid);
	public List<OrderBean> listByCpid(int id);
	public List<OrderBean> listByRentalId(int id);
	public int insertOrder(OrderBean orderBean);
	public int updateOrder(int orderid,int status);
	public TimeBeanDto bantime(int rentalId);
	public void outoftime(int uid);
}

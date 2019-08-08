package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.pojo.OrderBean;
import com.project.pojo.TimeBean;

@Mapper
public interface IOrderDao {
		public List<OrderBean> listbyOwnerId(int ownerid);
		public List<OrderBean> listByUserId(int uid);
		public List<OrderBean> listUnderwayByUserId(int uid);
		public List<OrderBean> listByCpid(int cpid);
		public List<OrderBean> listByRentalId(int rentalId);
		public OrderBean getById(int id);
		public int  insert(OrderBean orderBean);
		public int  update(@Param("id")int orderid,@Param("status")int status);
		public List<TimeBean> listBantime(int rentalId);
}

package com.project.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.pojo.UserBean;

@Mapper
public interface IUserDao {
		public UserBean getById(int id);
		public void addmoney(@Param("id")int uid,@Param("price")double price);
}

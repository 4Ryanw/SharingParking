package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.pojo.CarportBean;

@Mapper
public interface ICarportDao {
	public CarportBean getById(int id);
	public List<CarportBean> listAll();
	public int insertCarport(CarportBean carportBean);
	public int updateCarport(@Param("cp_id")int id ,@Param("cp_status")int status);
	public int deleteCarport(int id);
	public List<CarportBean> listByOwnerId(int id);
}

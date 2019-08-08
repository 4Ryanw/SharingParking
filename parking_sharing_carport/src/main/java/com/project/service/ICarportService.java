package com.project.service;

import java.util.List;

import com.project.pojo.CarportBean;

public interface ICarportService {
	public CarportBean getById(int id);
	public List<CarportBean> listAll();
	public List<CarportBean> listByOwnerId(int id);
	public int insert(CarportBean carportBean);
	public int update(int cpid,int status);
	public int delete(int id);
}

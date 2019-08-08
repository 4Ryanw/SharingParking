package com.project.service.Impl;

import java.util.List;

import org.omg.IOP.IOR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ICarportDao;
import com.project.dao.IOrderDao;
import com.project.dao.IUserDao;
import com.project.pojo.CarportBean;
import com.project.pojo.UserBean;
import com.project.service.ICarportService;

@Service
public class CarportServiceImpl implements ICarportService {
	
	@Autowired
	private ICarportDao ICarportDao;
	@Autowired
	private IUserDao IUserDao;
	@Override
	public CarportBean getById(int id) {
		 CarportBean carportBean = ICarportDao.getById(id);
		 UserBean owner = IUserDao.getById(carportBean.getCp_owner_id());
		 carportBean.setOwner(owner);
		 return carportBean;
	}
	@Override
	public List<CarportBean> listAll() {
		List<CarportBean> list = ICarportDao.listAll();
		for (CarportBean carportBean : list) {
			UserBean owner = IUserDao.getById(carportBean.getCp_owner_id());
			 carportBean.setOwner(owner);
		}
		 return list;
	}
	
	@Override
	public int insert(CarportBean carportBean) {
		
		return ICarportDao.insertCarport(carportBean);
	}
	@Override
	public int update(int id, int status) {
		
		return ICarportDao.updateCarport(id, status);
	}
	@Override
	public int delete(int id) {
		CarportBean carportBean = ICarportDao.getById(id);
		//如果车位已发布,则不能删除
		if (carportBean.getCp_status()==2) {
			return 0;
		}
		return ICarportDao.deleteCarport(id);
	}
	@Override
	public List<CarportBean> listByOwnerId(int id) {
	 List<CarportBean> list = ICarportDao.listByOwnerId(id);
		return list;
	}
	
}

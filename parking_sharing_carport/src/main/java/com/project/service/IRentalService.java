package com.project.service;

import java.util.List;

import com.project.pojo.CarportDTOBean;
import com.project.pojo.RentalBean;

public interface IRentalService {
	public List<RentalBean> listAll();
	public RentalBean getById(int id);
	public CarportDTOBean getByCpId(int id);
	public int insert(RentalBean rentalBean);
	public int updateRental(RentalBean rentalBean);
	public int updateRentalStatus(int rentalid,int status);
	public void cancelRental(int cpid);
}

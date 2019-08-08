package com.project.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IRentalDao;
import com.project.pojo.CarportBean;
import com.project.pojo.CarportDTOBean;
import com.project.pojo.OrderBean;
import com.project.pojo.RentalBean;
import com.project.service.ICarportService;
import com.project.service.IOrderService;
import com.project.service.IRentalService;

@Service
public class RentalServiceImpl implements IRentalService {
	
	@Autowired
	private ICarportService iCarportService;
	
	@Autowired
	private IRentalDao IRentalDao;
	
	@Autowired
	private IOrderService IOrderService;

	@Override
	public RentalBean getById(int id) {
	RentalBean rentalBean =	IRentalDao.getById(id);
	CarportBean carportBean =iCarportService.getById(rentalBean.getR_cp_id());
	rentalBean.setCarportBean(carportBean);
		return rentalBean;
	}

	/* (non-Javadoc)
	 * @see com.project.service.IRentalService#insert(com.project.pojo.RentalBean)
	 * 发布车位
	 */
	@Override
	public int insert(RentalBean rentalBean) {
			int result = IRentalDao.insertRental(rentalBean);
			int carportId =rentalBean.getR_cp_id();
			iCarportService.update(carportId, 2);
			return  result ;
	}

	/* (non-Javadoc)
	 * @see com.project.service.IRentalService#updateRental(com.project.pojo.RentalBean)
	 * 修改租用信息
	 */
	@Override
	public int updateRental(RentalBean rentalBean) {
		return IRentalDao.updateRental(rentalBean);
	}

	/* (non-Javadoc)
	 * @see com.project.service.IRentalService#updateRentalStatus(int, int)
	 * 改变车位发布信息的状态 状态默认为0未失效  1表示已失效 
	 */
	@Override
	public int updateRentalStatus(int rentalid, int status) {
		return IRentalDao.updateRentalStatus(rentalid, status);
	
	}

	@Override
	public List<RentalBean> listAll() {
		List<RentalBean> result = new ArrayList<RentalBean>();
		List<RentalBean> list = IRentalDao.listAll();
		for (RentalBean rentalBean : list) {
		int rid = rentalBean.getR_id();
		rentalBean = this.getById(rid);
		result.add(rentalBean);
		}
		return result;
	}

	@Override
	public CarportDTOBean getByCpId(int id) {
		CarportDTOBean carportDTOBean = new CarportDTOBean();
		CarportBean carportBean = iCarportService.getById(id);
		List<OrderBean> list = IOrderService.listByCpid(id);
		RentalBean rentalBean= IRentalDao.getByCpId(id);
		carportDTOBean.setCarportBean(carportBean).setList(list).setRentalBean(rentalBean).setStatus(carportBean.getCp_status());
		return carportDTOBean;
	}

	@Override
	public void cancelRental(int cpid) {
		iCarportService.update(cpid, 1);
		int rid =	this.getByCpId(cpid).getRentalBean().getR_id();
		this.updateRentalStatus(rid, 1);
	}
	
	
	
	
}

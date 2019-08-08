package com.project.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ordernumber;
import com.project.dao.IOrderDao;
import com.project.dao.IUserDao;
import com.project.pojo.OrderBean;
import com.project.pojo.RentalBean;
import com.project.pojo.TimeBeanDto;
import com.project.service.IMessageService;
import com.project.service.IOrderService;
import com.project.service.IRentalService;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IRentalService IRentalService;
	//@Autowired
	//private ICarportService ICarportService;
	
	@Autowired
	private IOrderDao IOrderDao;
	
	@Autowired
	IMessageService IMessageService;
	
	@Autowired
	private IUserDao IUserDao;
	
	public String DatetoString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		String str = sdf.format(date);
		return str;
	}
	
	@Override
	public OrderBean getById(int id) {
		OrderBean orderBean =IOrderDao.getById(id);
		orderBean.setStime(DatetoString(orderBean.getO_stime()));
		orderBean.setEtime(DatetoString(orderBean.getO_etime()));
		orderBean.setRentalBean(IRentalService.getById(orderBean.getO_r_id()));
		orderBean.setUserBean(IUserDao.getById(orderBean.getO_u_id()));
		return orderBean;
	}
	
	/* (non-Javadoc)
	 * @see com.project.service.IOrderService#insertOrder(com.project.pojo.OrderBean)
	 * 生成订单
	 */
	@Override
	public int insertOrder(OrderBean orderBean) {
		orderBean.setO_createtime(new Date());
		orderBean.setO_code(Ordernumber.getOrderNo()); 
		/**
		 * 给包租婆发通知
		 * */
		RentalBean rentalBean = IRentalService.getById(orderBean.getO_r_id());
		IMessageService.insert(1, "您有新的订单",rentalBean.getCarportBean().getCp_owner_id() );
		return IOrderDao.insert(orderBean);
	}

	@Override
	public int updateOrder(int orderid, int status) {
		OrderBean orderBean =this.getById(orderid);
		int userId = orderBean.getO_u_id();
	//int carportId =orderBean.getRentalBean().getCarportBean().getCp_id();
		IOrderDao.update(orderid, status);
		switch (status) {
		case 1: // 1表示接单 ,并通知用户
			IMessageService.insert(2, "您的订单已被接受", userId);
			break;
		case 2: //2表示拒绝,仅通知用户
			IMessageService.insert(2, "包租婆拒绝了您的订单请求", userId);
			break;
		case 3: //3表示订单已完成,通知用户
			IMessageService.insert(2, "订单已完成", userId);
			break;

		default:
			break;
		}
		return 1;
	}

	@Override
	public List<OrderBean> listByCpid(int id) {
	 List<OrderBean> list =	IOrderDao.listByCpid(id);
	 List<OrderBean> result = new ArrayList<>();
	 for (OrderBean orderBean : list) {
		orderBean = this.getById(orderBean.getO_id());
		result.add(orderBean);
	}
		return result;
	}

	@Override
	public List<OrderBean> listByRentalId(int id) {
		List<OrderBean> list = IOrderDao.listByRentalId(id);
		 for (OrderBean orderBean : list) {
				orderBean = this.getById(orderBean.getO_id());
			}
		return list;
	}

	@Override
	public TimeBeanDto bantime(int rentalId) {
		TimeBeanDto timeBeanDto = new TimeBeanDto();
		timeBeanDto.setMax(IRentalService.getById(rentalId).getR_etime());
	 	Date rentalstime = IRentalService.getById(rentalId).getR_stime();
	 	Date now =  new Date();
	 	//判断现在时间和订单起始时间
		timeBeanDto.setMin(now.after(rentalstime)?now:rentalstime);
		 timeBeanDto.setListtime(IOrderDao.listBantime(rentalId));
		 return timeBeanDto;
	}

	@Override
	public List<OrderBean> listByUserId(int userid) {
		 List<OrderBean> list =	IOrderDao.listByUserId(userid);
		 List<OrderBean> list2 = new ArrayList<OrderBean>();
		 for (OrderBean orderBean : list) {
				orderBean = this.getById(orderBean.getO_id());
				list2.add(orderBean);
		 }
		return list2;
	}

	@Override
	public void outoftime(int uid) {
		Date now = new Date();
	List<OrderBean> list = 	IOrderDao.listUnderwayByUserId(uid);
	for (OrderBean orderBean : list) {
		System.out.println("判断");
		if(now.after(orderBean.getO_etime())){
			System.out.println("修改");
			IOrderDao.update(orderBean.getO_id(),3 );
			orderBean = this.getById(orderBean.getO_id());
			int owid =orderBean.getRentalBean().getCarportBean().getCp_owner_id();
			System.out.println(owid);
			//IUserDao.addmoney(, orderBean.getO_price());
		}
	}
	}

	@Override
	public List<OrderBean> listByOwnerID(int ownerid) {
		
		return IOrderDao.listbyOwnerId(ownerid);
	}

	

}

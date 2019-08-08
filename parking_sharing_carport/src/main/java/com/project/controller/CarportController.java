package com.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.common.feignInterfaces.UserHandler;
import com.project.dao.IUserDao;
import com.project.pojo.CarportBean;
import com.project.pojo.CarportDTOBean;
import com.project.pojo.ComplainBean;
import com.project.pojo.MessageBean;
import com.project.pojo.OrderBean;
import com.project.pojo.RentalBean;
import com.project.pojo.TimeBeanDto;
import com.project.pojo.UserBean;
import com.project.pojo.xinyuBean;
import com.project.service.ICarportService;
import com.project.service.IComplainService;
import com.project.service.IMessageService;
import com.project.service.IOrderService;
import com.project.service.IRentalService;
@RestController
public class CarportController {
		@Autowired
		private IRentalService iRentalService;
		@Autowired
		private IUserDao IUserDao;
		@Autowired
		private IOrderService IOrderService;
		@Autowired
		private ICarportService ICarportService;
		@Autowired
		private UserHandler UserHandler;
		 
		@Autowired
		IComplainService iComplainService;
		//public static int uid = 1;
		
		@Autowired
		IMessageService IMessageService;
		/**
		 * 查询所有租车信息
		 * @return
		 */
		@RequestMapping("/carport/findAll")
		public List<RentalBean> listAll(){
			return iRentalService.listAll();
		}
		
		@RequestMapping("/carport/updateoutoftime")
		public void outoftime(){
			int uid = UserHandler.getUserId();
			IOrderService.outoftime(uid);
		}
		
		/**
		 * 通过id查询租车信息
		 * @param id
		 * @return
		 */
		@RequestMapping("/carport/findById/{id}")
		public RentalBean findByid(@PathVariable("id")int id){
			return iRentalService.getById(id);
		}
		
		/**
		 * 通过车位id查询租车信息
		 * @param id
		 * @return
		 */
		@RequestMapping("/carport/findByCpId/{id}")
		public CarportDTOBean findCpByid(@PathVariable("id")int id){
			return  iRentalService.getByCpId(id);
		}
	
		
		
		/**查询订单详情
		 * @return
		 */
		@RequestMapping("/carport/findOrderByid")
		public OrderBean findById(int id){
			return IOrderService.getById(id);
		}
		
		
		
		/**
		 * 查询禁用时间
		 * @param id
		 * @return
		 */
		@RequestMapping("/carport/findBanTime/{id}")
		public TimeBeanDto bantime(@PathVariable("id")int id){
			return IOrderService.bantime(id) ;
		}
		
		public Date wrformat(String date) {
			date =date.replace("\"", "");
			date =date.replace("Z", " UTC");
			Date date1 = null ;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			try {
				 date1 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date1;
		}
		
		/**
		 * 预定下订单
		 * @param id
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping("/carport/insertOrder")
		public String reserveOrder(HttpServletRequest request, HttpServletResponse response){
			int uid = UserHandler.getUserId();
			Date star = this.wrformat(request.getParameter("start"));
			Date end = this.wrformat(request.getParameter("end"));
			int rid = Integer.parseInt(request.getParameter("id"));
			int day= Integer.parseInt(request.getParameter("day"));
			double price= Double.parseDouble(request.getParameter("price"));
			String words= request.getParameter("words");
			OrderBean orderBean = new OrderBean();
			orderBean.setDay(day).setO_etime(end).setO_price(price).setO_r_id(rid).setO_stime(star).setO_u_id(uid).setO_words(words);
			IOrderService.insertOrder(orderBean);
			IUserDao.addmoney(uid, (0-price));
			return "ok";
		}
		
		
		/**查询用户所有订单
		 * @return
		 */
		@RequestMapping("/carport/finduserOrder")
		public List<OrderBean> listAllorder(){
			int uid = UserHandler.getUserId();
			return IOrderService.listByUserId(uid);
		}
			
			
		/**
		 * 添加车位
		 * @param id
		 * @param request
		 * @return
		 */
		@RequestMapping("/carport/insertcarport")
		public int addcarport(HttpServletRequest request){
		int uid = UserHandler.getUserId();
		String 	describe = request.getParameter("describe");
		System.out.println(describe);
 		String	address=request.getParameter("address");
		 String number = request.getParameter("number");
		 String certifacateNumber = request.getParameter("certifacateNumber");
		// String certifacate = request.getParameter("certifacate");
		 String community = request.getParameter("community");
			CarportBean carportBean = new CarportBean();
			carportBean.setCp_address(address).setCp_describe(describe).setCp_certificateNumber(certifacateNumber).setCp_community(community).setCp_number(number).setCp_owner_id(uid);
			carportBean.setCp_certificate("先写死");
			return ICarportService.insert(carportBean);
		}
				
			
		/**
		 * 查询所有我的车位
		 * @return
		 */
		@RequestMapping("/carport/findMycp")
		public List<CarportBean> listMycp(){
			
			int uid = UserHandler.getUserId();
			return ICarportService.listByOwnerId(uid);
		}	
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		/**
		 * 发布租车信息
		 * @param id
		 * @param request
		 * @return
		 */
		@RequestMapping("/carport/insertRental")
		public int addRental(HttpServletRequest request){
			RentalBean  rentalBean = new RentalBean();	
			int cpid = Integer.parseInt(request.getParameter("cpid")) ;
				double price = Double.parseDouble(request.getParameter("price"));
			try {
				Date stime = sdf2.parse(request.getParameter("start"));
				Date etime = sdf2.parse(request.getParameter("end"));
				rentalBean.setR_cp_id(cpid).setR_price(price).setR_stime(stime).setR_etime(etime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return iRentalService.insert(rentalBean);
		}
		
		@RequestMapping("/carport/updateRental")
		public void cancelRental(int id){
			iRentalService.cancelRental(id);
		}
		
		
		@RequestMapping("/carport/findUser")
		public UserBean getUserByid(){
		int uid = UserHandler.getUserId();
		return IUserDao.getById(uid);
		}
		
		/**
		 * 查询未处理订单请求
		 * @param id
		 * @return
		 */
		@RequestMapping("/carport/listOrderBycpId")
		public List<OrderBean> listOrderBycpId(int id){
			
			return IOrderService.listByCpid(id);
		}
		
		
		/**
		 * 处理订单请求 (没用到这个 可以删了)
		 * @param request
		 */
		@RequestMapping("/carport/updateOrder")
		public void  handleOrder(HttpServletRequest request){
		int orderid	=Integer.parseInt(request.getParameter("orderId"));
		int status=Integer.parseInt(request.getParameter("status"));
		IOrderService.updateOrder(orderid, status);
		}
		
		/**
		 * 添加投诉
		 * @param orderid
		 * @param btid
		 * @param content
		 */
		@RequestMapping("/carport/insertcharge")
		public void insertcharge(int orderid,int btid,String content){
			int uid = UserHandler.getUserId();
			ComplainBean complainBean = new ComplainBean();
			complainBean.setCo_btuid(btid).setCo_tuid(uid).setCo_content(content).setCo_o_id(orderid).setCo_createtime(new Date());
			iComplainService.insertComplain(complainBean);
		}
		
		
		/**查询信誉度.. 鬼才取名
		 * @param rentalid
		 * @return
		 */
		@RequestMapping("/carport/findXinyu")
		public xinyuBean findxinyuBycpnerid(int rentalid){
			int ownerid = iRentalService.getById(rentalid).getCarportBean().getCp_owner_id();
			xinyuBean xinyuBean = new xinyuBean();
			int charge = 0;
			int total = 0;
		   List<OrderBean> olist =  IOrderService.listByOwnerID(ownerid);
		   for (OrderBean orderBean : olist) {
				if (orderBean.getO_status()==3) {
					total+=1;
				}
		   }
		   List<ComplainBean> clist = iComplainService.listcomplainByownerId(ownerid);
		   charge = clist.size();
		   xinyuBean.setTotal(total);
		   xinyuBean.setCharge(charge);
			return xinyuBean;
		}
		
		/**查通知
		 * @return
		 */
		@RequestMapping("/carport/findMessage")
		public List<MessageBean> listMyMessage(){
			int uid = UserHandler.getUserId();
			return 	IMessageService.list(uid);
		}
		
		/**删通知消息
		 * @param id
		 */
		@RequestMapping("/carport/deleteMessage")
		public void removeMessage(int id){
			IMessageService.delete(id);
		}
}

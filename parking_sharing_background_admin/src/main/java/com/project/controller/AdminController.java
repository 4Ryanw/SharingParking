/**
 * 
 */
package com.project.controller;



import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parking.common.pojo.AdminBean;
import com.parking.common.pojo.AuthorityBean;
import com.project.bean.PageBean;
import com.project.service.IAdminService;
import com.project.service.IAuthorityService;

/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月26日 上午10:26:20 

* 类说明 

*/
@Controller
public class AdminController {
	@Autowired
	private IAdminService adService;
	@Autowired
	private IAuthorityService auService;
	
	private AuthorityBean au;
	//注销
	@RequestMapping("/admin/logout")
	@ResponseBody
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "ok";
	}
	/**
	 * 管理员登录
	 * @author tengwei
	 * @date   2019年7月26日
	 * @param ad 传一个管理员对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin/login")
	public String login(AdminBean ad){
		//产生一个用户（门面对象）
		Subject currentUser = SecurityUtils.getSubject();//
		if (!currentUser.isAuthenticated()) {
		        UsernamePasswordToken token = new UsernamePasswordToken(ad.getA_name(),ad.getA_password());
			try {
				//调用login进行认证
				currentUser.login(token);
				System.out.println("认证成功");
				AdminBean admin = adService.login(ad.getA_name());
				Session session = currentUser.getSession(true);
				//认证成功放入session
				session.setAttribute("admin",admin);
				
				//放权限
				au = auService.selectByAdminId(admin.getA_id());
				
				//session.setAttribute("authority", au);
				return "success";
			} catch (UnknownAccountException uae) {
				System.out.println("用户名异常");
				return "name_false";
			} catch (IncorrectCredentialsException ice) {
				System.out.println("密码异常");
				return "password_false";
			} catch (LockedAccountException lae) {
			   System.out.println("被锁定异常");
			   return "user_lock";
			}
		}
		return "success";
	}
	/**
	 * 修改管理员信息
	 * @author tengwei
	 * @date   2019年7月26日
	 * @param ad
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin/updateInfo")
	public Boolean AdminUpdateInfo(AdminBean ad){
		AdminBean admin = (AdminBean) SecurityUtils.getSubject().getSession().getAttribute("admin");
		ad.setA_id(admin.getA_id());
		Object obj = new SimpleHash("MD5",ad.getA_password(),ad.getA_name(),1024);
		ad.setA_password(obj.toString());
		Boolean boo = adService.updateInfo(ad);
		return boo;
	}
	/**
	 * 显示管理信息
	 * @author tengwei
	 * @date   2019年7月26日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin/findAdmin")
	public AdminBean showAdmin(){
		AdminBean admin = (AdminBean) SecurityUtils.getSubject().getSession().getAttribute("admin");
		return admin;
	}
	/**
	 * 修改权限
	 * @author tengwei
	 * @date   2019年7月27日
	 * @param au
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin/updateAuthority")
	public Boolean updateAuthority(AuthorityBean au){
		
		Boolean boo = auService.updateAdminAuthority(au);
		return boo;
	}
	
	/**
	 * 显示所有管理员
	 * @author tengwei
	 * @date   2019年7月27日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin/findAllAdmin")
	public PageBean showAllAdmin(int page,int size){
		PageBean pb = adService.selectAllAdmin(page,size);
		return pb;
	}
	/**
	 * 判断用户名是否存在
	 * @author tengwei
	 * @date   2019年7月28日
	 * @param a_name
	 * @return
	 */
	@ResponseBody
	@GetMapping("/admin/isExist")
	public Boolean AdminIsExist(String a_name){
		if(adService.selectAdminByName(a_name)!=null){
			return true;
		}
		return false;
	}
	//添加管理员
	@ResponseBody
	@RequestMapping("/admin/insertAdmin")
	public Boolean addAdmin(AdminBean ad){
		AdminBean admin = (AdminBean) SecurityUtils.getSubject().getSession().getAttribute("admin");
		System.out.println(admin+"admin探监=======");
		Object obj = new SimpleHash("MD5",ad.getA_password(),ad.getA_name(),1024);
		ad.setA_password(obj.toString());
		Boolean boo = adService.insertAdmin(ad);
		return  boo;
	}
	//删除管理员
	@ResponseBody
	@RequestMapping("/admin/deleteAdmin")
	public Boolean deleAdmin(int a_id){
		Boolean boo = adService.deleteAdmin(a_id);
		
		return boo;
	}
	//根据用户名查找管理员
	@ResponseBody
	@RequestMapping("/admin/selectByName")
	public List<AdminBean> selectByName(String a_name){
		AdminBean ad = adService.selectAdminByName(a_name);
		List<AdminBean> list = new ArrayList<AdminBean>();
		if (ad==null) {
			return list;
		}
		list.add(ad);
		return list;
	}
	
	//查询权限
	@ResponseBody
	@RequestMapping("/admin/getAuthorityById")
	public AuthorityBean showAuthority(int a_id){
		AuthorityBean au = auService.selectByAdminId(a_id);
		return au;
	}
	
	
	@PostMapping(value="/admin/getAdmin")
	@ResponseBody
	public AdminBean getAdmin(){
		AdminBean admin = (AdminBean) SecurityUtils.getSubject().getSession().getAttribute("admin");
		
		return admin;
	}
	
	@PostMapping(value="/admin/getMyAuthority")
	@ResponseBody
	public AuthorityBean getMyAuthroity(){
		
		return au;
	}
	
}

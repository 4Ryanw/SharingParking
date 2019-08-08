package com.parking.user.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parking.common.feignInterfaces.AdminHandler;
import com.parking.common.pojo.AuthorityBean;
import com.parking.common.pojo.User;
import com.parking.user.bean.UserBean;
import com.parking.user.bean.UserPageBean;
import com.parking.user.service.UserService;
import com.parking.user.util.UserUtil;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	//喷粪
	@Autowired
	private AdminHandler auService;
	
	private Integer userId;
	private User user;

	@RequestMapping("/user/login")
	@ResponseBody
	public int login(String username, String password) {
		// 产生一个用户（门面对象）
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				// 调用login进行认证
				currentUser.login(token);
				System.out.println("认证成功");
			} catch (UnknownAccountException uae) {
				System.out.println("用户名错误，返回1");
				return 1;
			} catch (IncorrectCredentialsException ice) {
				System.out.println("密码错误，返回2");
				return 2;
			} catch (LockedAccountException lae) {
				System.out.println("被锁定异常，返回3");
				return 3;
			}
		}
		user = service.ShiroLogin(username);
		userId = user.getUid();
		Session session = currentUser.getSession(true);
		session.setAttribute("user", user);
		session.setAttribute("id", user.getUid());
		
		//认证成功返回0	
		return 0;
	}

	@RequestMapping("/user/insertuser")
	@ResponseBody
	public int Reg(User user) {
		int num = service.findByUsername(user.getUsername());
		if (num == 1) {
			System.out.println("该用户已存在");
			return 0;
		} else {
			System.out.println("用户不存在，可以注册");
			Object obj = new SimpleHash("MD5",user.getPassword(),user.getUsername(),1024);
			user.setPassword(obj.toString());
			boolean boo = service.insertMessage(user);
			if (boo) {
				// 注册成功
				return 1;
			} else {
				// 注册失败
				return 2;
			}
		}
	}
	@ResponseBody
	@RequestMapping("/user/logout")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "ok";
	}
	
	/**
	 * 个人中心信息显示
	 * @author tengwei
	 * @date   2019年7月25日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user/findPerson")
	public UserBean showPerson(){
		User user = UserUtil.getUser();
		System.out.println(user.getUid()+"user.getUid()");
		UserBean user1 = service.selectUserById(user.getUid());
		System.out.println(user1);
		
		return user1;
	}
	//修改信息
	@ResponseBody
	@RequestMapping("/user/updateInfo")
	public Boolean updateInfo(UserBean user){
		Boolean boo = false;
		User u = UserUtil.getUser();
		user.setU_id(u.getUid());
		boo = service.updateUserInfo(user);
		
		return boo;
	}
	//改密码
	@ResponseBody
	@RequestMapping("/user/updatePassword")
	public String updatePassword(UserBean userBean,String oldPassword){
		Boolean boo = false;
		//从session中获取user
		User user = UserUtil.getUser();
		//将输入的原密码加密
		Object obj1 = new SimpleHash("MD5",oldPassword,user.getUsername(),1024);
		//若输入的原密码和session中的密码相同，则可以修改
		if(user.getPassword().equals(obj1.toString())){
			//将session中的用户id放入user中
			userBean.setU_id(user.getUid());
			Object obj2 = new SimpleHash("MD5",userBean.getU_password(),user.getUsername(),1024);
			userBean.setU_password(obj2.toString());
			
			
			boo = service.updateUserInfo(userBean);
			//如果修改成功 跳转至登录页面
			if(boo){
				Subject currentUser = SecurityUtils.getSubject();
				currentUser.logout();
				return "ok";
			}
			return "false";
		}
		
		return "pwd_error";
	}
	//显示所有用户
	@ResponseBody
	@RequestMapping("/user/findAllUser")
	public UserPageBean showAllUser(int page,int size){
		UserPageBean pb = service.selectAllUser(page,size);
		return pb;
	}
	//修改用户状态
	@ResponseBody
	@RequestMapping("/user/updateState")
	public UserPageBean updateState(int u_id,int u_state,int page){
		//先修改用户状态，再查询分页
		System.out.println(u_id+":"+u_state+":"+page);
		Boolean boo = service.updateState(u_id,u_state);
		if(boo){
			return showAllUser(page,8);
		}
		return null;
	}
	//获取当前管理员权限
	@RequestMapping("/user/findMyAuthroity")
	@ResponseBody
	public AuthorityBean getAuthority(){
		AuthorityBean au = auService.getMyAuthroity();
		
		System.out.println("user权限"+au);
		
		return au;
	}
	
	/**
     * 获取session中的user对象
     */
	@GetMapping(value="/user/getUser")
	@ResponseBody
    public User getUser(){
    	//User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    	return user;
    }
    
    /**
     * 获取session中的userId
     */
    @GetMapping(value="/user/getUserId")
    @ResponseBody
    public Integer getUserId(){
    	//Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("id");
    	return userId;
    }
}

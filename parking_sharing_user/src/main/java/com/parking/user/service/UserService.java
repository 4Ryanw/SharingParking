package com.parking.user.service;

import com.parking.common.pojo.User;
import com.parking.user.bean.UserBean;
import com.parking.user.bean.UserPageBean;

public interface UserService {
	//判断账户是否存在（登陆、注册）
	public Integer findByUsername(String username);
	//判断账户密码是否正确
	public User ShiroLogin(String username);
	//添加注册信息
	public boolean insertMessage(User user);
	
	/**
	 * 修改用户信息
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param user 用户
	 * @return
	 */
	Boolean updateUserInfo(UserBean user);
	/**
	 * 查询用户
	 * @author tengwei
	 * @date   2019年7月24日
	 * @param u_id
	 * @return
	 */
	UserBean selectUserById(int u_id);
	/**
	 * @author tengwei
	 * @date   2019年7月30日
	 * @return
	 */
	UserPageBean selectAllUser(int page,int size);
	/**
	 * @author tengwei
	 * @date   2019年7月31日
	 * @param u_id
	 * @return
	 */
	Boolean updateState(int u_id,int u_state);
}

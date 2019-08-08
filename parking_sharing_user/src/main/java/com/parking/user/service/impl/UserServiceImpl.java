package com.parking.user.service.impl;

import com.parking.user.bean.UserBean;
import com.parking.user.bean.UserPageBean;
import com.parking.user.dao.UserDao;
import com.parking.user.service.UserService;
import com.parking.common.pojo.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	
	/**
	 * 查询用户是否存在 1存在   0不存在
	 */
	@Override
	public Integer findByUsername(String username) {
		User user = dao.findByName(username);
		if (user!=null) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	/**
	 * 验证登陆，1登陆成功   0登陆失败
	 */
	@Override
	public User ShiroLogin(String username) {
		User user = dao.Login(username);
		return user;
	}

	@Override
	public boolean insertMessage(User user) {
		int num = dao.Reg(user);
		return num==1?true:false;
	}
	@Override
	public Boolean updateUserInfo(UserBean user) {
		int row = dao.updateInfo(user);
		if (row>0) return true;
		return false;
	}

	@Override
	public UserBean selectUserById(int u_id) {
		UserBean user = dao.selectUserById(u_id);
		return user;
	}

	@Override
	public UserPageBean selectAllUser(int page,int size) {
		UserPageBean pb = new UserPageBean();
		List<UserBean> list = dao.selectAllUser();
		int pageNumber = (list.size()%size==0)?(list.size()/size):(list.size()/size+1);
		int userNumber = list.size();
		List<UserBean> list2 = dao.selectUserByPage((page-1)*size,size);
		pb.setList(list2);
		pb.setPageNumber(pageNumber);
		pb.setUserNumber(userNumber);
		return pb;
	}

	@Override
	public Boolean updateState(int u_id,int u_state) {
		int row = dao.updateState(u_id,u_state);
		if(row>0) return true;
		return false;
	}
}

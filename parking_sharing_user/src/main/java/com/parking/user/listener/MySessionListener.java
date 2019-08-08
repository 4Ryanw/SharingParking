package com.parking.user.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.parking.common.feignInterfaces.LogHandler;
import com.parking.common.pojo.User;


/**
 * SessionListener
 * SessionListenerAdapter
 * @author Mac Book Pro
 *
 */
public class MySessionListener implements SessionListener{
	@Autowired
	private LogHandler service;

	@Override
	public void onStart(Session session) {
		System.out.println("session创建监听");
	}
	@Override
	public void onStop(Session session) {
		System.out.println("session销毁监听");
		User userBean = (User) session.getAttribute("user");
		service.logoutLog(userBean.getUsername());
		System.out.println("============================================");
	}

	@Override
	public void onExpiration(Session session) {
		System.out.println("session过期监听");
		User userBean = (User) session.getAttribute("user");
		service.logoutLog(userBean.getUsername());
		System.out.println("============================================");
	}
	
}

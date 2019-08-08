package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.common.pojo.Login_outLog;
import com.parking.service.ILogin_outService;

@RestController
public class LoginLogHandler {
	@Autowired
	private ILogin_outService loginService;
	
	@RequestMapping("/in_outLog/findThreeDays")
	public List<Login_outLog> findThreeDays(){
		List<Login_outLog> list = loginService.findThreeDays();
		return list;
	}
	
	@RequestMapping(value="/in_outLog/findByTime")
	public List<Login_outLog> findByTime(String startTime,String stopTime){
		List<Login_outLog> list = loginService.findByTime(startTime,stopTime);
		return list;
	}
	
	@RequestMapping("/in_outLog/findOnlineNum")
	public Integer findOnlineNum(){
		Integer onlineNum = loginService.findOnlineNum();
		return onlineNum;
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/in_outLog/getOutLog/{username}")
	public String logoutLog(@PathVariable("username")String username){
		Login_outLog bean = new Login_outLog();
		bean.setL_userName(username);
		bean.setL_login_out("注销");
		loginService.add(bean);
		return "ok";
	}
	
	/**
	 * 
	 * @return
	 */
	//@RequestMapping(value="/in_outLog/getInLog",method=RequestMethod.POST)
	@PostMapping(value="/in_outLog/getInLog")
	public String loginLog(@RequestBody Login_outLog bean){
		loginService.add(bean);
		return "ok";
	}

}

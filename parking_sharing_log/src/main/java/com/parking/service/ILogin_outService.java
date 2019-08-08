package com.parking.service;


import java.util.List;

import com.parking.common.pojo.Login_outLog;


public interface ILogin_outService {
	public List<Login_outLog> findThreeDays();
	public List<Login_outLog> findByTime(String startTime,String stopTime);
	public int add(Login_outLog bean);
	//public void deleteByTime(String startTime,String stopTime);
	public int findOnlineNum();
}

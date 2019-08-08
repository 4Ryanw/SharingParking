package com.parking.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.parking.common.pojo.Login_outLog;
import com.parking.common.util.IpAddressUtil;
import com.parking.dao.ILogin_outDao;
import com.parking.service.ILogin_outService;

@Service
public class Login_outServiceImpl implements ILogin_outService {
	
	@Autowired
	private ILogin_outDao logDao;
	
	@Autowired
	private IpAddressUtil ipAddressUtil;

	@Override
	public List<Login_outLog> findByTime(String startTime, String stopTime) {
		stopTime += " 23:59:59";
		List<Login_outLog> list = logDao.findByTime(startTime, stopTime);
		return list;
	}

	@Override
	public int add(Login_outLog bean) {
		Date da = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(da);
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
		//得到当前电脑的ip
		String ipAddress = ipAddressUtil.getIpAddr(request);
		
		bean.setL_logTime(time);
		bean.setL_ipAddress(ipAddress);
		int num = logDao.add(bean);
		return num;
	}

	@Override
	public List<Login_outLog> findThreeDays() {
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//Calendar calendar =new GregorianCalendar();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, -3);
		date = calendar.getTime();
		String startTime = dateFormat.format(date);
		calendar.add(calendar.DATE, 4);
		date = calendar.getTime();
		String stopTime = dateFormat.format(date);
		//System.out.println(startTime+"1111 "+stopTime);
		List<Login_outLog> list = logDao.findByTime(startTime, stopTime);
		return list;
	}

	@Override
	public int findOnlineNum() {
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Calendar calendar =new GregorianCalendar();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.MINUTE, -5);
		date = calendar.getTime();
		String startTime = dateFormat.format(date);
		calendar.add(calendar.MINUTE, 6);
		date = calendar.getTime();
		String stopTime = dateFormat.format(date);
		//System.out.println(startTime+"1111 "+stopTime);
		int onlineNum = logDao.findOnlineNum(startTime, stopTime);
		return onlineNum;
	}

	

}

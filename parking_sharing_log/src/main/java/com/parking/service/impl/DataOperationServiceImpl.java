package com.parking.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.common.pojo.DataOperationLog;
import com.parking.dao.IDataOperationDao;
import com.parking.service.IDataOperationService;

@Service
public class DataOperationServiceImpl implements IDataOperationService {
	
	@Autowired
	private IDataOperationDao dataDao;

	@Override
	public List<DataOperationLog> findByTime(String startTime, String stopTime) {
		stopTime += " 23:59:59";
		List<DataOperationLog> list = dataDao.findByTime(startTime, stopTime);
		return list;
	}

	@Override
	public int add(DataOperationLog bean) {
		int num = dataDao.add(bean);
		return num;
	}

	@Override
	public void deleteByTime(String startTime, String stopTime) {
		dataDao.deleteByTime(startTime, stopTime);
		
	}

	@Override
	public List<DataOperationLog> findThreeDays() {
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
		List<DataOperationLog> list = dataDao.findByTime(startTime, stopTime);
		return list;
	}

}

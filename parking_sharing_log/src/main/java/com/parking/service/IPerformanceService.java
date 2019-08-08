package com.parking.service;


import java.util.List;

import com.parking.common.pojo.PerformanceLog;


public interface IPerformanceService {
	public Integer[] findByRequestTime();
	public int add(PerformanceLog bean);
	public void deleteByTime(String startTime,String stopTime);
}

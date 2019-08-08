package com.parking.service;


import java.util.List;

import com.parking.common.pojo.DataOperationLog;


public interface IDataOperationService {
	public List<DataOperationLog> findThreeDays();
	public List<DataOperationLog> findByTime(String startTime,String stopTime);
	public int add(DataOperationLog bean);
	public void deleteByTime(String startTime,String stopTime);
}

package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.common.pojo.DataOperationLog;
import com.parking.common.pojo.PerformanceLog;
import com.parking.service.IDataOperationService;

@RestController
public class OperationLogHandler {
	@Autowired
	private IDataOperationService dataService;
	
	@RequestMapping("/dataOperationLog/findThreeDays")
	public List<DataOperationLog> findThreeDays(){
		List<DataOperationLog> list = dataService.findThreeDays();
		return list;
	}
	
	@RequestMapping(value="/dataOperationLog/findByTime")
	public List<DataOperationLog> findByTime(String startTime,String stopTime){
		List<DataOperationLog> list = dataService.findByTime(startTime, stopTime);
		return list;
	}
	
	/**
	 * 
	 * @return
	 */
	//@RequestMapping(value="/dataOperationLog/getDataOperationLog",method=RequestMethod.POST)
	@PostMapping(value="/dataOperationLog/getDataOperationLog")
	public String dataLog(@RequestBody DataOperationLog bean){
		dataService.add(bean);
		return "ok";
	}

}

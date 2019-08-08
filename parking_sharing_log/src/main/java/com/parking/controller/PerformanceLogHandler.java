package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.common.pojo.Login_outLog;
import com.parking.common.pojo.PerformanceLog;
import com.parking.service.IPerformanceService;

@RestController
public class PerformanceLogHandler {
	@Autowired
	private IPerformanceService perService;
	
	@RequestMapping("/performanceLog/findByRequestTime")
	public Integer[] findByRequestTime(){
		Integer[] arr = perService.findByRequestTime();
		return arr;
	}
	
	/**
	 * 
	 * @return
	 */
	//@RequestMapping(value="/performanceLog/getPerformanceLog",method=RequestMethod.POST)
	@PostMapping(value="/performanceLog/getPerformanceLog")
	public String performanceLog(@RequestBody PerformanceLog bean){
		perService.add(bean);
		return "ok";
	}

}

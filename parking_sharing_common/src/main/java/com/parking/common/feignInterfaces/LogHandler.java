package com.parking.common.feignInterfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.parking.common.pojo.DataOperationLog;
import com.parking.common.pojo.Login_outLog;
import com.parking.common.pojo.PerformanceLog;



@FeignClient(name = "PARKING-SHARING-LOG")
public interface LogHandler {
	/**
	 * 
	 */
	@GetMapping("/in_outLog/getOutLog/{username}")
	public String logoutLog(@PathVariable("username")String username);
	
	//@RequestMapping(value="/in_outLog/getInLog",method=RequestMethod.POST)
	@PostMapping(value="/in_outLog/getInLog")
	public String loginLog(@RequestBody Login_outLog bean);//Login_outLog bean
	
	//@RequestMapping(value="/performanceLog/getPerformanceLog",method=RequestMethod.POST)
	@PostMapping(value="/performanceLog/getPerformanceLog")
	public String performanceLog(@RequestBody PerformanceLog bean);
	
	//@RequestMapping(value="/dataOperationLog/getDataOperationLog",method=RequestMethod.POST)
	@PostMapping(value="/dataOperationLog/getDataOperationLog")
	public String dataLog(@RequestBody DataOperationLog bean);
}

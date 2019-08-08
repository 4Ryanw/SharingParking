package com.parking.common.feignInterfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parking.common.pojo.User;



@FeignClient(name="PARKING-SHARING-USER")
public interface UserHandler {
	/**
	 * 获取user对象
	 */
	@GetMapping("/user/getUser")
	@ResponseBody
	public User getUser();
	
	/**
	 * 获取user对象
	 */
	@GetMapping("/user/getUserId")
	@ResponseBody
	public Integer getUserId();
}

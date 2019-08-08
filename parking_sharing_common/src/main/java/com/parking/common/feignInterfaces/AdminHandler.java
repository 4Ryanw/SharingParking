package com.parking.common.feignInterfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parking.common.pojo.AdminBean;
import com.parking.common.pojo.AuthorityBean;



@FeignClient(name = "PARKING-SHARING-ADMIN")
public interface AdminHandler {
	/**
	 * 获取admin对象
	 */
	@PostMapping(value="/admin/getAdmin")
	@ResponseBody
	public AdminBean getAdmin();
	
	@PostMapping(value="/admin/getMyAuthority")
	@ResponseBody
	public AuthorityBean getMyAuthroity();
}

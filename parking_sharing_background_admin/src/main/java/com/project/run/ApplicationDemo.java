/**
 * 
 */
package com.project.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.parking.common.util.IpAddressUtil;

/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月23日 下午8:03:47 

* 类说明 

*/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.parking.common.feignInterfaces")
@ComponentScan({"com.project.service","com.project.bean","com.project.controller","com.project.config","com.project.listener","com.project.filter"})
@MapperScan("com.project.dao")
public class ApplicationDemo {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}
	@Bean
    public IpAddressUtil ipAddressUtil() {
    	return new IpAddressUtil();
    }
}

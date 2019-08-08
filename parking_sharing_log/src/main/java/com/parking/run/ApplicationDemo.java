package com.parking.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.parking.common.util.IpAddressUtil;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.parking.common.feignInterfaces")
@ComponentScan({"com.parking.controller","com.parking.service"})
@MapperScan("com.parking.dao")
public class ApplicationDemo {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}
	
	 
    @Bean
    public IpAddressUtil ipAddressUtil() {
    	return new IpAddressUtil();
    }
}

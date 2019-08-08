package com.parking.user;

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
@ComponentScan({"com.parking.user.config","com.parking.user.controller","com.parking.user.service","com.parking.user.listener","com.parking.user.filter"})
@MapperScan("com.parking.user.dao")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
    
    @Bean
    public IpAddressUtil ipAddressUtil() {
    	return new IpAddressUtil();
    }
}

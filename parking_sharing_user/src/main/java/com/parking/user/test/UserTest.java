package com.parking.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parking.common.pojo.User;
import com.parking.user.dao.UserDao;
import com.parking.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	private UserDao dao;
	@Autowired
	private UserService service;
	
	@Test
	public void test1(){
		System.out.println(dao.findByName("zzy"));
	}
	
	@Test
	public void test2(){
		User user = new User();
		user.setAddress("sss").setEmail("aaa").setIdcard("564664").setJob("ssss").setPassword("123456").setPhone("151515151");
		user.setRealname("zzz").setUsername("zzzzz");
		System.out.println(dao.Reg(user));
	}
	
	@Test
	public void test3(){
		System.out.println(dao.Login("zzy"));
	}
	
	@Test
	public void test4(){
		System.out.println(service.findByUsername("zzy"));
	}
	
	@Test
	public void test5(){
		System.out.println(service.ShiroLogin("zzy"));
	}
	
	@Test
	public void test6(){
		User user = new User();
		user.setAddress("sss").setEmail("aaa").setIdcard("564664").setJob("ssss").setPassword("123456").setPhone("151515151");
		user.setRealname("zzz").setUsername("zzzzz"); 
		System.out.println(service.insertMessage(user));
	}
}

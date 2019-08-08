package com.project.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parking.dao.IPerformanceDao;
import com.parking.run.ApplicationDemo;
import com.parking.service.ILogin_outService;
import com.parking.service.IPerformanceService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationDemo.class)
public class ServiceTest {
	@Autowired
	private ILogin_outService LogService;
	
	@Autowired
	private IPerformanceService perService;
	
	@Autowired
	private IPerformanceDao perDao;
	
	@Test
	public void findThreeDays() {
		//List<Login_outLog> list = LogService.findThreeDays();
		//System.out.println(list);
	}

	@Test
	public void performanceLog(){
		Integer[] arr = perService.findByRequestTime();
		for (Integer integer : arr) {
			System.out.println(integer);
		}
		
	}
	
	@Test
	public void daolog(){
		Integer count1 = perDao.findByRequestTime(3001, 5000);
		System.out.println(count1);
	}
}

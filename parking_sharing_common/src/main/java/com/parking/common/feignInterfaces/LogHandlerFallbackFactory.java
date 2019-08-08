package com.parking.common.feignInterfaces;

import org.springframework.stereotype.Component;

import com.parking.common.pojo.DataOperationLog;
import com.parking.common.pojo.Login_outLog;
import com.parking.common.pojo.PerformanceLog;

import feign.hystrix.FallbackFactory;

@Component //加上注解，扫描的时候才能扫描到当前类
public class LogHandlerFallbackFactory implements FallbackFactory<LogHandler>{

	@Override
	public LogHandler create(Throwable arg0) {
		return new LogHandler(){

			@Override
			public String logoutLog(String username) {
				
				return "服务降级";
			}

			/*@Override
			public String loginLog(Login_outLog bean) {
				// TODO Auto-generated method stub
				return null;
			}*/

			@Override
			public String performanceLog(PerformanceLog bean) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String dataLog(DataOperationLog bean) {
				// TODO Auto-generated method stub
				return null;
			}


			@Override
			public String loginLog(Login_outLog bean) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}

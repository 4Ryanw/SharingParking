package com.parking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.parking.common.pojo.Login_outLog;


public interface ILogin_outDao {
	@Select("select * from t_login_out_log where l_logTime between #{startTime} and #{stopTime}")
	public List<Login_outLog> findByTime(@Param("startTime")String startTime,@Param("stopTime")String stopTime);
	
	@Insert("insert into t_login_out_log(l_userName,l_logTime,l_ipAddress,l_login_out) "
			+ "values(#{l_userName},#{l_logTime},#{l_ipAddress},#{l_login_out})")
	public int add(Login_outLog bean);
	
	@Delete("delete from t_login_out_log where l_logTime between #{startTime} and #{stopTime}")
	public void deleteByTime(@Param("startTime")String startTime,@Param("stopTime")String stopTime);

	@Select("select count(l_logTime) from t_login_out_log where l_login_out='登录' and l_logTime between #{startTime} and #{stopTime}")
	public int findOnlineNum(@Param("startTime")String startTime,@Param("stopTime")String stopTime);
}

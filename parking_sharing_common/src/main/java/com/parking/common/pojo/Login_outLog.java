package com.parking.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 登入登出日志
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Login_outLog {
	private int l_id;
	private String l_userName;
	private String l_logTime;
	private String l_ipAddress;
	private String l_login_out;
	
	

}

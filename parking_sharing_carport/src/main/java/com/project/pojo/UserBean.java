package com.project.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserBean {
	private int u_id;
	private String u_username;
	private String u_password;
	private String u_realname;
	private String u_address;
	private String u_phone;
	private String u_idcard;
	private String u_job;
	private String u_email;
	private double u_money;
}

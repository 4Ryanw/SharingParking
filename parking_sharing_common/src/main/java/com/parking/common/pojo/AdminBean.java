package com.parking.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class AdminBean implements Serializable
{
	private int a_id;
	private String a_password;
	//工号
	private String a_number;
	//账号
	private String a_name;
	private String a_phone;
	//角色
	private int a_role;
}

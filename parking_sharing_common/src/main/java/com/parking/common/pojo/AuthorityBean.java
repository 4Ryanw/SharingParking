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
public class AuthorityBean implements Serializable
{
	//管理员id即管理员id
	private int a_adid;
	//管理员
	private AdminBean ad;
	//管理用户权限
	private int a_ua;
	//管理车位权限
	private int a_cpa;
	//管理投诉权限
	private int a_coa;
}

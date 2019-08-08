package com.project.bean;

public class AdminBean {
	private int a_id;
	private String a_password;
	//工号
	private String a_number;
	//账号
	private String a_name;
	private String a_phone;
	//角色
	private int a_role;
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public String getA_number() {
		return a_number;
	}
	public void setA_number(String a_number) {
		this.a_number = a_number;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	
	public int getA_role() {
		return a_role;
	}
	public void setA_role(int a_role) {
		this.a_role = a_role;
	}
	@Override
	public String toString() {
		return "AdminBean [a_id=" + a_id + ", a_password=" + a_password + ", a_number=" + a_number + ", a_name="
				+ a_name + ", a_phone=" + a_phone + ", a_role=" + a_role + "]";
	}
	
	
	
}

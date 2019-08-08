/**
 * 
 */
package com.parking.user.bean;
/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月23日 下午5:21:42 

* 类说明 

*/
public class UserBean {
	private int u_id;
	//用户名 不可改
	private String u_username;
	private String u_password;
	//真实姓名  不可改
	private String u_realname;
	private String u_address;
	private String u_phone;
	//身份证   不可改
	private String u_idcard;
	//职业
	private String u_job;
	private String u_email;
	private int u_state;
	
	public int getU_state() {
		return u_state;
	}
	public void setU_state(int u_state) {
		this.u_state = u_state;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_realname() {
		return u_realname;
	}
	public void setU_realname(String u_realname) {
		this.u_realname = u_realname;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_idcard() {
		return u_idcard;
	}
	public void setU_idcard(String u_idcard) {
		this.u_idcard = u_idcard;
	}
	public String getU_job() {
		return u_job;
	}
	public void setU_job(String u_job) {
		this.u_job = u_job;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	@Override
	public String toString() {
		return "UserBean [u_id=" + u_id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_realname="
				+ u_realname + ", u_address=" + u_address + ", u_phone=" + u_phone + ", u_idcard=" + u_idcard
				+ ", u_job=" + u_job + ", u_email=" + u_email + ", u_state=" + u_state + "]";
	}
	
	
}

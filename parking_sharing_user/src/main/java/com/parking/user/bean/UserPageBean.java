/**
 * 
 */
package com.parking.user.bean;

import java.util.List;

/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月31日 上午10:30:10 

* 类说明 

*/
public class UserPageBean {
	private List<UserBean> list;
	private int pageNumber;
	private int userNumber;
	public List<UserBean> getList() {
		return list;
	}
	public void setList(List<UserBean> list) {
		this.list = list;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	@Override
	public String toString() {
		return "UserPageBean [list=" + list + ", pageNumber=" + pageNumber + ", userNumber=" + userNumber + "]";
	}
	
	
}

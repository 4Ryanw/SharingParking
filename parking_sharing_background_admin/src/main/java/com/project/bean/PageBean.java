package com.project.bean;
import java.util.List;
import com.parking.common.pojo.AdminBean;
/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月31日 下午3:29:29 

* 类说明 

*/
public class PageBean {
	private List<AdminBean> list;
	private int pageNumber;
	private int adminNumber;
	public List<AdminBean> getList() {
		return list;
	}
	public void setList(List<AdminBean> list) {
		this.list = list;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	@Override
	public String toString() {
		return "PageBean [list=" + list + ", pageNumber=" + pageNumber + ", adminNumber=" + adminNumber + "]";
	}
	
}

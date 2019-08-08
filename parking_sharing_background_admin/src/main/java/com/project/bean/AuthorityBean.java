/**
 * 
 */
package com.project.bean;
/** 

* @author 作者：tengwei 

* @time 创建时间：2019年7月23日 下午4:27:56 

* 类说明 

*/
public class AuthorityBean {
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
	public int getA_adid() {
		return a_adid;
	}
	public void setA_adid(int a_adid) {
		this.a_adid = a_adid;
	}
	public AdminBean getAd() {
		return ad;
	}
	public void setAd(AdminBean ad) {
		this.ad = ad;
	}
	public int getA_ua() {
		return a_ua;
	}
	public void setA_ua(int a_ua) {
		this.a_ua = a_ua;
	}
	public int getA_cpa() {
		return a_cpa;
	}
	public void setA_cpa(int a_cpa) {
		this.a_cpa = a_cpa;
	}
	public int getA_coa() {
		return a_coa;
	}
	public void setA_coa(int a_coa) {
		this.a_coa = a_coa;
	}
	@Override
	public String toString() {
		return "AuthorityBean [a_adid=" + a_adid + ", ad=" + ad + ", a_ua=" + a_ua + ", a_cpa=" + a_cpa + ", a_coa="
				+ a_coa + "]";
	}
	
}

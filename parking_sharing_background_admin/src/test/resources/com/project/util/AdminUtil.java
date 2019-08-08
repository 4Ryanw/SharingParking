/**
 * 
 */
package com.project.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.parking.common.pojo.AdminBean;
import com.parking.common.pojo.AuthorityBean;


/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月31日 下午7:53:12 

* 类说明 

*/
public class AdminUtil {
	private static Subject currentUser = SecurityUtils.getSubject();
	private static Session session = currentUser.getSession(true);
	//获取管理员
	public static AdminBean getAdmin(){
		
		AdminBean admin = (AdminBean) session.getAttribute("admin");
		return admin;
	}
	//获取权限
	public static AuthorityBean getAuthority(){
		AuthorityBean au = (AuthorityBean) session.getAttribute("authority");
		return au;
	}
}

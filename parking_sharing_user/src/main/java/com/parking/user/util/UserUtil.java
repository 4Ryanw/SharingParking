/**
 * 
 */
package com.parking.user.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.parking.common.pojo.User;

/** 

* @author 作者：tengwei 

* @version 创建时间：2019年8月1日 下午2:17:28 

* 类说明 

*/
public class UserUtil {
	//获取用户
	public static User getUser(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession(true);
		return (User) session.getAttribute("user");
	}
	
}

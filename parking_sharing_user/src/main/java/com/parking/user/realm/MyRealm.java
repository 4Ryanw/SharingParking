package com.parking.user.realm;

import com.parking.common.pojo.User;
import com.parking.user.service.UserService;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService service;
	
	/**
	 * 权限设置
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	/**
	 * 身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			User user = service.ShiroLogin((String)token.getPrincipal());
			//未查找到用户，则不再进行验证，返回验证失败
			if(user == null) {
				return null;
			}
			//获取到学员的身份信息，用用户名进行验证，用户名也为空，则返回验证失败
			String username = user.getUsername();
			//手机号用户名均为空，返回验证失败
			if(username == null) {
				return null;
			}
			ByteSource by = ByteSource.Util.bytes(user.getUsername());
			return new SimpleAuthenticationInfo(user,user.getPassword(),by,this.getName());
	}

}

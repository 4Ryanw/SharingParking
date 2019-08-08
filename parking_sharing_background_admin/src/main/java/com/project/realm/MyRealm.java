package com.project.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.parking.common.pojo.AdminBean;
import com.project.service.IAdminService;


/**
 * 安全数据源
 * @author Administrator
 *
 */
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private IAdminService adService;
	
	
	/**
	 * 学员权限设置
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	/**
	 * 学员身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String principal = token.getPrincipal().toString();
		AdminBean ad = adService.login(principal);
		//身份验证
		if(ad!=null) {
			ByteSource by = ByteSource.Util.bytes(ad.getA_name());
			return new SimpleAuthenticationInfo(ad,ad.getA_password(),by,this.getName());
		}
		
		return null;
	}

}

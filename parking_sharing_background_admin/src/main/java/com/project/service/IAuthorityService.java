/**
 * 
 */
package com.project.service;

import com.parking.common.pojo.AuthorityBean;

/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月23日 下午5:50:49 

* 类说明 

*/
public interface IAuthorityService {
	/**
	 * 修改管理员权限
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param au 权限对象
	 * @return 
	 */
	Boolean updateAdminAuthority(AuthorityBean au);
	/**
	 * 查询管理员权限
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param a_adid 管理员id
	 * @return 权限对象
	 */
	AuthorityBean selectByAdminId(int a_adid);
}

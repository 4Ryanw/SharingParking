/**
 * 
 */
package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.common.pojo.AuthorityBean;
import com.project.dao.IAuthorityDao;
import com.project.service.IAuthorityService;

/** 

* @author 作者：tengwei 

* @version 创建时间：2019年7月23日 下午5:53:39 

* 类说明 

*/
@Service
public class AuthorityServiceImpl implements IAuthorityService {
	@Autowired
	private IAuthorityDao auDao;
	
	@Override
	public Boolean updateAdminAuthority(AuthorityBean au) {
		int row = auDao.updateAuthority(au);
		if (row>0) return true;
		return false;
	}

	@Override
	public AuthorityBean selectByAdminId(int a_adid) {
		AuthorityBean au = auDao.selectByAdminId(a_adid);
		return au;
	}
}

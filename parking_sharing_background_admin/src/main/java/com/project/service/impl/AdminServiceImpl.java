package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parking.common.pojo.AdminBean;
import com.parking.common.pojo.AuthorityBean;
import com.project.bean.PageBean;
import com.project.dao.IAdminDao;
import com.project.dao.IAuthorityDao;
import com.project.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private IAdminDao adminDao;
	@Autowired
	private IAuthorityDao auDao;
	
	@Override
	public PageBean selectAllAdmin(int page,int size) {
		PageBean pb = new PageBean();
		List<AdminBean> list = adminDao.selectAllAdmin();
		int pageNumber = (list.size()%size==0)?(list.size()/size):(list.size()/size+1);
		int adminNumber = list.size();
		List<AdminBean> list2 = adminDao.selectUserByPage((page-1)*size,size);
		pb.setList(list2);
		pb.setPageNumber(pageNumber);
		pb.setAdminNumber(adminNumber);
		return pb;
	}
	
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public Boolean insertAdmin(AdminBean ad) {
		//先查询此用户名是否存在
		AdminBean ad1 = adminDao.selectByName(ad.getA_name());
		if (ad1!=null) return false;
		
		//先添加管理员，再添加管理员权限
		int row = adminDao.insertAdmin(ad);
		//查询自增长Id
		AdminBean ad2 = adminDao.selectByName(ad.getA_name());
		AuthorityBean au = new AuthorityBean();
		au.setA_adid(ad2.getA_id());
		//如果添加的是超级管理员，拥有所有权限
		if (ad.getA_role()==1) {
			au.setA_coa(1);
			au.setA_cpa(1);
			au.setA_ua(1);
		}
		int row2 = auDao.insertAuthority(au);
		if (row > 0 && row2 > 0) return true;
		return false;
	}

	@Override
	public Boolean updateInfo(AdminBean ad) {
		int row = adminDao.updateInfo(ad);
		if(row>0) return true;
		return false;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public Boolean deleteAdmin(int a_id) {
		//先删除管理员权限，再删除管理员
		int row1 = auDao.deleteAuthority(a_id);
		int row2 = adminDao.deleteAdmin(a_id);
		if (row1 > 0 && row2 > 0) return true;
		return false;
	}


	@Override
	public AdminBean login(String a_name) {
		AdminBean ad = adminDao.selectByName(a_name);
		return ad;
	}


	@Override
	public AdminBean selectAdminByName(String a_name) {
		AdminBean ad = adminDao.selectByName(a_name);
		return ad;
	}
}

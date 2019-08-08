package com.project.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IComplainDao;
import com.project.pojo.ComplainBean;
import com.project.service.IComplainService;
import com.project.service.IMessageService;

@Service
public class ComplainServiceImpl implements IComplainService {

	@Autowired
	IComplainDao IComplainDao;
	@Autowired
	IMessageService IMessageService;

	@Override
	public void insertComplain(ComplainBean complainBean) {
		IComplainDao.insertComplain(complainBean);
		IMessageService.insert(3, complainBean.getCo_content(), complainBean.getCo_btuid());
	}

	@Override
	public List<ComplainBean> listcomplainByownerId(int btId) {
		return IComplainDao.listcomplainByownerid(btId);
	}
	
	
	
	

}

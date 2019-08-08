package com.project.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IMessageDao;
import com.project.pojo.MessageBean;
import com.project.service.IMessageService;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private IMessageDao IMessageDao;

	@Override
	public int insert(int type, String content, int userId) {
		MessageBean messageBean = new MessageBean();
		messageBean.setM_type(type);
		messageBean.setM_content(content);
		messageBean.setM_u_id(userId);
		return IMessageDao.insertMessage(messageBean);
	}

	@Override
	public void delete(int id) {
		IMessageDao.deleteMessage(id);
	}

	@Override
	public List<MessageBean> list(int uid) {
		return IMessageDao.list(uid);
			
	}

}

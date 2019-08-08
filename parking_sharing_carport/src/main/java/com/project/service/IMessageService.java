package com.project.service;

import java.util.List;

import com.project.pojo.MessageBean;

public interface IMessageService {
			public int insert(int type,String content,int userId);
			public void delete(int id);
			public List<MessageBean> list(int uid);
}

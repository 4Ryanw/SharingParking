package com.project.service;

import java.util.List;

import com.project.pojo.ComplainBean;

public interface IComplainService {
	public void insertComplain(ComplainBean complainBean);
	public  List<ComplainBean>  listcomplainByownerId(int btId);
}

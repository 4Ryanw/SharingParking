package com.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.bean.ComplainBean;
import com.project.dao.IComplainDao;
import com.project.service.IComplainService;

/**
 * 投诉业务层实现类
 * 
 * @author YuChen
 *
 */
@Service
public class ComplainServiceImpl implements IComplainService {
    @Autowired
    private IComplainDao complainDao;

    @Override
    public List<ComplainBean> findComplainByStatus(int status) {
        return complainDao.findComplainByStatus(status);
    }

    @Override
    public List<ComplainBean> findComplainByPage(int page, int size) {
        return complainDao.findComplainByPage((page - 1) * size, size);
    }

    @Override
    public List<ComplainBean> findComplainByStatusAndPage(int status, int page, int size) {
        return complainDao.findComplainByStatusAndPage(status, (page - 1) * size, size);
    }

    @Override
    public List<ComplainBean> findComplainByTuid(int tuId) {
        return complainDao.findComplainByTuid(tuId);
    }

    @Override
    public List<ComplainBean> findComplainByBtuid(int btuId) {
        return complainDao.findComplainByBtuid(btuId);
    }

    @Override
    public ComplainBean findComplainById(int id) {
        return complainDao.findComplainById(id);
    }

    @Override
    public int findComplainNumberByStatus(int status) {
        return complainDao.findComplainNumberByStatus(status);
    }

    @Override
    public int updateComplainStatus(int id, int status, String result) {
        return complainDao.updateComplainStatus(id, status, result);
    }

    @Override
    public int addCompalin(ComplainBean complain) {
        return complainDao.addCompalin(complain);
    }

    @Override
    public int deleteComplain(int id) {
        return complainDao.deleteComplain(id);
    }

}

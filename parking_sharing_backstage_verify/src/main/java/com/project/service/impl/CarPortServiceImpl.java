package com.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.bean.CarPortBean;
import com.project.dao.ICarPortDao;
import com.project.service.ICarPortService;

/**
 * 车位业务实现类
 * 
 * @author YuChen
 *
 */
@Service
public class CarPortServiceImpl implements ICarPortService {
    @Autowired
    private ICarPortDao carPortDao;

    @Override
    public List<CarPortBean> findCarPortByStatus(int status) {
        return carPortDao.findCarPortByStatus(status);
    }

    @Override
    public CarPortBean findCarPortById(int id) {
        return carPortDao.findCarPortById(id);
    }

    @Override
    public List<CarPortBean> findCarPortByStatusAndPage(int status, int page, int size) {
        return carPortDao.findCarPortByStatusAndPage(status, (page - 1) * size, size);
    }

    @Override
    public int updateCarPortStatus(int id, int status) {
        return carPortDao.updateCarPortStatus(id, status);
    }

    @Override
    public int findCarPortNumberByStatus(int status) {
        return carPortDao.findCarPortNumberByStatus(status);
    }

}

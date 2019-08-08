package com.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IUserService;

/**
 * 用户业务层实现类
 * 
 * @author YuChen
 *
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public UserBean findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<UserBean> findAllUser() {
        return userDao.findAllUser();
    }

}

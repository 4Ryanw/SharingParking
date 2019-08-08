package com.project.service;

import java.util.List;

import com.project.bean.UserBean;

/**
 * 用户业务层接口
 * 
 * @author YuChen
 *
 */
public interface IUserService {

    UserBean findUserById(int id);

    List<UserBean> findAllUser();
}

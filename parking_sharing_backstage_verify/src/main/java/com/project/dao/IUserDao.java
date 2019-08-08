package com.project.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project.bean.UserBean;

@Mapper
public interface IUserDao {
    /**
     * 通过用户id查询用户
     * 
     * @param id
     * @return 用户对象
     */
    UserBean findUserById(int id);

    List<UserBean> findAllUser();

}

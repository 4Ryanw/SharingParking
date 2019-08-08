package com.project.service;

import java.util.List;
import com.project.bean.CarPortBean;

/**
 * 车位业务层接口
 * 
 * @author YuChen
 *
 */
public interface ICarPortService {

    List<CarPortBean> findCarPortByStatus(int status);

    /**
     * 通过车位审核状态分页查询
     * 
     * @param status 车位审核状态
     * @param page   页数
     * @param size   每页显示数
     * @return CarPortBean集合
     */
    List<CarPortBean> findCarPortByStatusAndPage(int status, int page, int size);

    /**
     * 通过车位id查询
     * 
     * @param id
     * @return
     */
    CarPortBean findCarPortById(int id);

    /**
     * 更新审核车位状态
     * 
     * @param id
     * @param status
     * @return
     */
    int updateCarPortStatus(int id, int status);

    /**
     * 通过车位审批状态查询车位
     * 
     * @param status
     * @return
     */
    int findCarPortNumberByStatus(int status);

}

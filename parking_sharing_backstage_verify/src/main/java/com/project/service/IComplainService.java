package com.project.service;

import java.util.List;
import com.project.bean.ComplainBean;

/**
 * 投诉业务层接口
 * 
 * @author YuChen
 *
 */
public interface IComplainService {

    /**
     * 通过处理状态查询投诉记录
     * 
     * @param status
     * @return
     */
    List<ComplainBean> findComplainByStatus(int status);

    /**
     * 分页查询投诉记录
     * 
     * @param page
     * @param size
     * @return
     */
    List<ComplainBean> findComplainByPage(int page, int size);

    /**
     * 通过投诉记录处理状态分页查询投诉记录
     * 
     * @param page
     * @param size
     * @return
     */
    List<ComplainBean> findComplainByStatusAndPage(int status, int page, int size);

    /**
     * 通过投诉用户id查询投诉记录
     * 
     * @param tuid
     * @return
     */
    List<ComplainBean> findComplainByTuid(int tuId);

    /**
     * 通过被投诉用户id查询投诉记录
     * 
     * @param btuid
     * @return
     */
    List<ComplainBean> findComplainByBtuid(int btuId);

    /**
     * 通过id查询投诉记录
     * 
     * @param id
     * @return
     */
    ComplainBean findComplainById(int id);

    /**
     * 根据投述处理状态查询投诉记录数量
     * 
     * @param status
     * @return 指定状态投诉的数量
     */
    int findComplainNumberByStatus(int status);

    /**
     * 更新投诉状态
     * 
     * @param id
     * @param status 状态
     * @param result 处理意见
     * @return
     */
    int updateComplainStatus(int id, int status, String result);

    /**
     * 添加投诉
     * 
     * @param complain
     * @return 影响行数
     */
    int addCompalin(ComplainBean complain);

    /**
     * 删除投诉
     * 
     * @param id 投诉id
     * @return
     */
    int deleteComplain(int id);
}

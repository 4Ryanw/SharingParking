package com.project.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.project.bean.CarPortBean;

/**
 * 车位持久层接口
 * 
 * @author YuChen
 *
 */
@Mapper
public interface ICarPortDao {
    /**
     * 通过id查询车位
     * 
     * @param id
     * @return
     */
    CarPortBean findCarPortById(int id);

    /**
     * 通过车位审批状态查询车位
     * 
     * @param status
     * @return
     */
    List<CarPortBean> findCarPortByStatus(int status);

    /**
     * 通过车位审批状态查询车位
     * 
     * @param status
     * @param beginIndex
     * @param size
     * @return
     */
    List<CarPortBean> findCarPortByStatusAndPage(@Param("status") int status, @Param("beginIndex") int beginIndex,
            @Param("size") int size);

    /**
     * 更新车位审核状态
     * 
     * @param id
     * @param status
     * @return
     */
    @Update("UPDATE t_carport SET cp_status=#{status} WHERE cp_id=#{id}")
    int updateCarPortStatus(@Param("id") int id, @Param("status") int status);

    /**
     * 通过状态查询车位数量
     * 
     * @param status
     * @return
     */
    @Select("SELECT COUNT(cp_id) FROM t_carport WHERE cp_status=#{status};")
    int findCarPortNumberByStatus(int status);

}

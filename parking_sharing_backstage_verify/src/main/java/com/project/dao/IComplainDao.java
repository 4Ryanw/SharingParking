package com.project.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.project.bean.ComplainBean;

/**
 * 投诉持久层接口
 * 
 * @author YuChen
 *
 */
@Mapper
public interface IComplainDao {
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
     * @param beginIndex
     * @param size
     * @return
     */
    List<ComplainBean> findComplainByPage(@Param("beginIndex") int beginIndex, @Param("size") int size);

    /**
     * 通过投诉记录处理状态分页查询投诉记录
     * 
     * @param status
     * @param beginIndex
     * @param size
     * @return
     */
    List<ComplainBean> findComplainByStatusAndPage(@Param("status") int status, @Param("beginIndex") int beginIndex,
            @Param("size") int size);

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
    @Select("SELECT COUNT(co_id) FROM t_complain WHERE co_status=#{status};")
    int findComplainNumberByStatus(int status);

    /**
     * 更新投诉状态
     * 
     * @param id
     * @param status
     * @return
     */
    @Update("UPDATE t_complain SET co_status=#{status},co_result=#{result} WHERE co_id=#{id}")
    int updateComplainStatus(@Param("id") int id, @Param("status") int status, @Param("result") String result);

    /**
     * 添加投诉
     * 
     * @param complain
     * @return 影响行数
     */
    @Insert("INSERT INTO t_complain(co_tuid,co_btuid,co_content,co_img,co_status,co_o_id,co_createtime,co_handletime) "
            + "VALUES(#{tuUser.id},#{btuUser.id},#{content},#{img},#{status},#{orderId},#{createTime},#{handleTime})")
    int addCompalin(ComplainBean complain);

    /**
     * 删除投诉
     * 
     * @param id
     * @return
     */
    @Delete("DELETE FROM t_complain WHERE co_id=#{id}")
    int deleteComplain(int id);

}

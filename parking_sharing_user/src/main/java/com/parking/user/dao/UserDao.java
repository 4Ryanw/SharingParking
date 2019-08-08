package com.parking.user.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.parking.common.pojo.User;
import com.parking.user.bean.UserBean;
@Mapper
public interface UserDao {	
	//通过用户名查询
    public User findByName(String username);
    //注册
    public int Reg(User user);
    //登录
    public User Login(String username);
    /**
	 * 修改用户信息
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param user 用户
	 * @return 影响行数
	 */
	int updateInfo(UserBean user);
	/**
	 * 查询用户信息
	 * @author tengwei
	 * @date   2019年7月24日
	 * @param u_id 用户id
	 * @return
	 */
	@Select("select * from t_user where u_id=#{u_id}")
	UserBean selectUserById(int u_id);
	/**
	 * @author tengwei
	 * @date   2019年7月30日
	 * @return
	 */
	@Select("select * from t_user")
	List<UserBean> selectAllUser();
	/**
	 * @author tengwei
	 * @date   2019年7月31日
	 * @param page
	 * @param size
	 * @return
	 */
	@Select("select * from t_user limit #{page},#{size}")
	List<UserBean> selectUserByPage(@Param("page")int page,@Param("size")int size);
	/**
	 * @author tengwei
	 * @date   2019年7月31日
	 * @param u_id
	 * @param u_state
	 * @return
	 */
	@Update("update t_user set u_state = #{u_state} where u_id=#{u_id}")
	int updateState(@Param("u_id")int u_id, @Param("u_state")int u_state);
}

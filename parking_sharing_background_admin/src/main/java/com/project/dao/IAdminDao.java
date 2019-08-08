package com.project.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.parking.common.pojo.AdminBean;

/**
 * 
 * @author tengwei
 * @time   2019年7月23日
 */
public interface IAdminDao {
	/**
	 * 修改密码、电话号码
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param a_id 管理员id
	 * @param newPwd 密码
	 * @return 影响行数
	 */
	int updateInfo(AdminBean ad);
	/**
	 * 查询所有管理员
	 * @author tengwei
	 * @date   2019年7月23日
	 * @return 管理员集合
	 */
	@Select("select * from t_admin")
	List<AdminBean> selectAllAdmin();
	/**
	 * 添加管理员
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param admin 管理员
	 * @return 影响行数
	 */
	@Insert("insert into t_admin(a_password,a_number,a_name,a_phone,a_role) "
			+ "values(#{a_password},#{a_number},#{a_name},#{a_phone},#{a_role})")
	//@SelectKey(statement ="SELECT LAST_INSERT_ID()",keyProperty="a_id",before=false,resultType=java.lang.Integer.class)
	//@Options(useGeneratedKeys = true, keyColumn = "a_id", keyProperty = "ad.a_id")
	int insertAdmin(AdminBean admin);
	/**
	 * 删除管理员
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param a_id 管理员id
	 * @return 影响行数
	 */
	@Delete("delete from t_admin where a_id=#{a_id}")
	int deleteAdmin(int a_id);
	/**
	 * @author tengwei
	 * @date   2019年7月24日
	 * @param a_name 用户名
	 * @return
	 */
	@Select("select * from t_admin where a_name=#{a_name}")
	AdminBean selectByName(String a_name);
	/**
	 * @author tengwei
	 * @date   2019年7月31日
	 * @param i
	 * @param size
	 * @return
	 */
	@Select("select * from t_admin limit #{page},#{size}")
	List<AdminBean> selectUserByPage(@Param("page")int page,@Param("size")int size);
}

/**
 * 
 */
package com.project.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.parking.common.pojo.AuthorityBean;


/** 

* @author 作者：tengwei 

* @time 创建时间：2019年7月23日 下午4:42:27 

* 类说明 

*/
public interface IAuthorityDao {
	/**
	 * 修改管理员权限
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param au 权限对象
	 * @return 影响行数
	 */
	@Update("update t_authority set a_ua=#{a_ua},a_cpa=#{a_cpa},a_coa=#{a_coa} where a_adid=#{a_adid}")
	int updateAuthority(AuthorityBean au);
	/**
	 * 删除权限对象
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param a_adid 权限id（管理员id）
	 * @return 影响行数
	 */
	@Delete("delete from t_authority where a_adid=#{a_adid}")
	int deleteAuthority(int a_adid);
	/**
	 * 添加权限信息
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param au 权限对象
	 * @return
	 */
	@Insert("insert into t_authority(a_adid,a_ua,a_cpa,a_coa) values(#{a_adid},#{a_ua},#{a_cpa},#{a_coa})")
	int insertAuthority(AuthorityBean au);
	/**
	 * 根据管理员id查询权限
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param a_adid 管理员ids
	 * @return 权限对象
	 */
	@Select("select * from t_authority where a_adid=#{a_adid}")
	AuthorityBean selectByAdminId(int a_adid);
}

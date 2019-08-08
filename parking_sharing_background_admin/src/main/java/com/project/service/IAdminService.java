package com.project.service;

import com.parking.common.pojo.AdminBean;
import com.project.bean.PageBean;

/**
 * 管理员业务操作接口
 */
public interface IAdminService {
	/**
	 * 查询所有管理员
	 * @author tengwei
	 * @date   2019年7月23日
	 * @return 管理员集合
	 */
	PageBean selectAllAdmin(int page,int size);
	/**
	 * 添加管理员
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param ad 管理员对象
	 * @return
	 */
	Boolean insertAdmin(AdminBean ad);
	/**
	 * 修改管理员信息
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param ad 管理员对象
	 * @return
	 */
	Boolean updateInfo(AdminBean ad);
	/**
	 * 删除管理员
	 * @author tengwei
	 * @date   2019年7月23日
	 * @param a_id 管理员id
	 * @return
	 */
	Boolean deleteAdmin(int a_id);
	/**
	 * @author tengwei
	 * @date   2019年7月26日
	 * @param a_name 用户名
	 * @return
	 */
	AdminBean login(String a_name);
	/**
	 * @author tengwei
	 * @date   2019年7月28日
	 * @param a_name
	 * @return
	 */
	AdminBean selectAdminByName(String a_name);
}

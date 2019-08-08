package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.project.pojo.MessageBean;

public interface IMessageDao {
	@Insert("insert into t_message values(null,#{m_type},#{m_content},#{m_u_id},0)")
	public int insertMessage(MessageBean messageBean);
	
	@Delete("delete from t_message where m_id =#{mid}")
	public void deleteMessage(int mid);
	
	@Select("select *from t_message where m_u_id = #{uid}")
	public List<MessageBean> list(int uid);
}

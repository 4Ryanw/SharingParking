package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.project.pojo.ComplainBean;

public interface IComplainDao {
	@Insert("insert into t_complain values(null,#{co_tuid},#{co_btuid},#{co_content},#{co_img},0,#{co_o_id},#{co_createtime},null,null)")
	public void insertComplain(ComplainBean complainBean);
	
	@Select("select * from t_complain where co_btuid =#{btid} ")
	public List<ComplainBean> listcomplainByownerid(int btid);
}

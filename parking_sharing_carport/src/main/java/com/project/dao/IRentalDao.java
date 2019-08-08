package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.pojo.RentalBean;

@Mapper
public interface IRentalDao {
		public List<RentalBean> listAll();
		public RentalBean getById(int id);
		public RentalBean getByCpId(int id);
		public int insertRental(RentalBean rentalBean);
		public int updateRental(RentalBean rentalBean);
		public int updateRentalStatus(@Param("id")int rentalid,@Param("r_status")int status);
}

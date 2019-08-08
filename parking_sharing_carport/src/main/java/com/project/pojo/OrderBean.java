package com.project.pojo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class OrderBean {
	private int o_id;
	private int o_u_id;
	private int o_r_id;
	private double o_price;
	private Date o_stime;
	private Date o_etime;
	private int o_status;
	private String o_words;
	private Date o_createtime;
	private int day;
	private String o_code;
	private RentalBean rentalBean;
	private UserBean userBean;
	private String stime;
	private String etime;
}

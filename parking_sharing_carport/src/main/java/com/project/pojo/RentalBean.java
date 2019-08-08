package com.project.pojo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class RentalBean {
	private int r_id;
	private int r_cp_id;
	private Date r_stime;
	private Date r_etime;
	private double r_price;
	private int r_status;
	private CarportBean carportBean;
}

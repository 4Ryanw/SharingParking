package com.project.pojo;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TimeBeanDto {
	private List<TimeBean> listtime;
	private Date max ;
	private Date min;
	
}

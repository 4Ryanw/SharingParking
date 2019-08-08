package com.project.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class CarportDTOBean {
	private CarportBean carportBean;
	private RentalBean rentalBean;
	private List<OrderBean> list;
	private int status;
}

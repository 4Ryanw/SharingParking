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
public class CarportBean {
	private int cp_id;
	private String cp_address;
	private String cp_number;
	private String cp_certificateNumber;
	private String cp_certificate;
	private String cp_describe;
	private int cp_status;
	private int cp_owner_id;
	private String cp_community;
	private UserBean owner;
	private List<OrderBean> orderlist;
}

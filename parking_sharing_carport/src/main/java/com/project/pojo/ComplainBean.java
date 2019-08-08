package com.project.pojo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@NoArgsConstructor
@Data
@Accessors(chain=true)
public class ComplainBean {
	private int co_id;
	private int co_tuid;
	private int co_btuid;
	private String co_content;
	private String co_img;
	private int co_status;
	private int co_o_id;
	private Date co_createtime;
	private Date co_handletime;
	private String co_result;
}

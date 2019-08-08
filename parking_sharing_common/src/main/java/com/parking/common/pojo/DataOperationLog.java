package com.parking.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 操作日志
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class DataOperationLog {
	private int da_id;
	private String da_userName;
	private String da_logTime;
	private String da_module;
	private String da_data;
	private String da_operation;
	
}

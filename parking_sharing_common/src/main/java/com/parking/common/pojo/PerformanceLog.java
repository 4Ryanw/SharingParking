package com.parking.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 性能日志
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class PerformanceLog {
	private int pe_id;
	private String pe_requestion;
	private int pe_requestTime;
	private String pe_stopTime;
	

}

package com.project.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MessageBean {
	private int m_id;
	private int m_type;
	private String m_content;
	private int m_u_id;
}

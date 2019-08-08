package com.parking.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class User implements Serializable {

    private Integer uid;

    private String username;

    private String password;

    private String realname;

    private String address;

    private String phone;

    private String idcard;

    private String job;

    private String email;
}

package com.parking.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Complain implements Serializable {

    private Integer id;

    private Integer tuid;

    private Integer btuid;

    private String content;

    private String img;

    private Integer status;

    private Integer oid;
}

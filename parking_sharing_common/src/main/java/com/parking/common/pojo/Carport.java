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
public class Carport implements Serializable {

    private Integer id;

    private String address;

    private String number;

    private String certificateNumber;

    private String certificate;

    private int status;

    private int ownerid;
}

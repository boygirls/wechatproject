package com.example.fdl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class tb_user implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
    private String face;
    private String sex;
    private Integer status;
    private String msg;
    private Integer role_id;
}

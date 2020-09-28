package com.example.fdl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "用户实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUser implements Serializable {
    private Long id;
    @ApiModelProperty(name = "username",value = "用户名")
    private String username;
    @ApiModelProperty(name = "password",value = "密码")
    private String password;

    private String phone;

    private String email;

    private Date created;

    private Date updated;

    private String face;

    private String sex;

    private Integer status;

    private String msg;

    private Long roleId;

}
package com.example.fdl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tb_order implements Serializable {
    private String order_id;
    private Integer status;
    private LocalDateTime create_time;
    private Integer user_id;
    private Tb_order_item tb_order_item;
}

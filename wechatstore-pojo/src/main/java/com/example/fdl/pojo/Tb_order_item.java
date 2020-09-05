package com.example.fdl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tb_order_item implements Serializable {
    private String id;
    private String item_id;
    private String order_id;
    private Integer num;
    private String title;
    private Long price;
    private Long total_fee;
    private String pic_path;
    private Integer status;
}

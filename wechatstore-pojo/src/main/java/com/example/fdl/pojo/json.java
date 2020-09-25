package com.example.fdl.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="订单信息类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class json {
    private Integer num;
    private Integer itemId;
}

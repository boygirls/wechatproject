package com.example.fdl.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="订单信息类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class json {
    @ApiModelProperty(name = "num",value = "数量")
    private Integer num;
    @ApiModelProperty(name = "itemId",value = "商品id")
    private Integer itemId;
}

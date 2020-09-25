package com.example.fdl.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.rmi.runtime.Log;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZWH_order_item implements Serializable {
    private Integer id;//主键
    private String item_id;//商品id
    private String order_id;//所在订单的id
    private Integer num;//商品数量

    private String title;//商品标题
    private Long price;//商品单价
    private Long total_fee;//商品总金额
    private String pic_path;//商品图片地址

    private Byte status;//状态 0--正常交易、1--申请退款  2--退款成功、3---撤销退款记录
}

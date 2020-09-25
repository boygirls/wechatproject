package com.example.fdl.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZWH_order_shipping implements Serializable {
    private String order_id;//订单Id
    private String receiver_name;//收货人全名
    private String receiver_phone;//固定电话
    private String receiver_mobile;//移动电话

    private String receiver_state;//省份
    private String receiver_city;//城市
    private String receiver_district;//区/县
    private String receiver_address;//收货地址

    private String receiver_zip;//邮政编码
    private LocalDateTime created;//发货时间
    private LocalDateTime updated;//更新时间
}

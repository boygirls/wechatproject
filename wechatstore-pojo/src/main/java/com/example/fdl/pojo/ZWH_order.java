package com.example.fdl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZWH_order implements Serializable {
    private String order_id;//订单id
    private Integer payment;//实支金额
    private Byte payment_type;//支付类型 1、在线支付，2、货到付款
    private String post_fee;//邮费

    private Byte status;//状态 1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭，7、待退款,8、退款成功
    private LocalDateTime create_time;//订单创建时间
    private LocalDateTime update_time;//订单更新时间
    private LocalDateTime payment_time;//付款时间

    private LocalDateTime consign_time;;//发货时间
    private LocalDateTime end_time;//发货时间
    private LocalDateTime close_time;//交易关闭时间
    private String shipping_name;//物流名称

    private String shipping_code;//物流单号
    private Integer user_id;//用户id
    private String buyer_message;//买家留言
    private String buYer_nick;//买家昵称

    private Byte buyer_rate;//买家是否已评价 1是 2否
}

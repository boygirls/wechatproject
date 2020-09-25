package com.example.fdl.mapper;

import com.example.fdl.pojo.ZWH_order_shipping;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ZWH_order_shipping_Mapper {

    //创建快递
    void createOrderShipping(ZWH_order_shipping zwh_order_shipping);
    //查找快递
    ZWH_order_shipping findOrderShipping(String orderId);
}

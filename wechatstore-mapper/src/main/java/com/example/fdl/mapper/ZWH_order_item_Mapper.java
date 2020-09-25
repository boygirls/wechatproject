package com.example.fdl.mapper;
import com.example.fdl.pojo.ZWH_order_item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ZWH_order_item_Mapper {
    //创建订单详情
    void createOrderItem(ZWH_order_item zwh_order_item);
    //根据订单Id查找
    List<ZWH_order_item> orderItemQueryByOrderId(String orderId);
    //根据订单Id修改状态
    void StatusByOrderId(String orderId,Byte status);
}

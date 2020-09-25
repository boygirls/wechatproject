package com.example.fdl.mapper;

import com.example.fdl.pojo.ZWH_order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ZWH_order_Mapper {
    //创建订单
    void createOrder(ZWH_order zwh_order);
    //根据用户id查询订单
    List<ZWH_order> orderQueryByUserId(Integer userId);
    //根据订单id修改订单状态
    void updateStatusByUserId(String orderId,Byte status);
}

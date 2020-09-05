package com.example.fdl.mapper;

import com.example.fdl.pojo.Tb_order;
import com.example.fdl.pojo.Tb_order_item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface orderMapper {

    void createOrder(Tb_order tb_order);

    void createOrder_item(Tb_order_item tb_order_item);

    List<Tb_order> findOrderById(Integer userId,Integer status);

    void updateOrderStatus(Integer orderId, Integer type);
}

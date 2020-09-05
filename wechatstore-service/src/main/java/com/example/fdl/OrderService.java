package com.example.fdl;

import com.example.fdl.common.R;
import com.example.fdl.mapper.goodsMapper;
import com.example.fdl.mapper.orderMapper;
import com.example.fdl.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {
    private static int status = 2;
    @Autowired
    orderMapper orderMapper;
    @Autowired
    goodsMapper goodsMapper;


    public R saveOrder(Integer userId, List<json> json) {
        System.out.println("List集合的大小=" + json.size());
        Tb_order_item tb_order_item = new Tb_order_item();
        Tb_order tb_order = new Tb_order();
        R<Object> R = new R<>();
        //循环遍历集合
        for (int j = 0; j < json.size(); j++) {
            //随机生成订单id
            //这里需要去获取数据后最大的订单id
            long r = System.currentTimeMillis();
            int i = (int)( r % 100 );
            LocalDateTime now = LocalDateTime.now();
            tb_order.setOrder_id("010" + i);
            System.out.println("订单id" + i);
            tb_order.setCreate_time(now);
            tb_order.setUser_id(userId);
            tb_order.setStatus(status);
            //根据用户id在tb-order中创建订单信息，
            orderMapper.createOrder(tb_order);
            json json1 = json.get(j);
            Integer itemId = json1.getItemId();
            tb_item tb = goodsMapper.queryGoodsById(itemId);
            if (tb == null){
                R.setSuccess("false");
                R.setMsg("please input id");
                return R;
            }

            //创建tb_order_item
            //根据返回的订单id创建tb_order_item中创建表填写信息

            tb_order_item.setId("00" + i);
            tb_order_item.setItem_id("" + json.get(j).getItemId());
            tb_order_item.setNum(json.get(j).getNum());
            tb_order_item.setTitle(tb.getTitle());
            tb_order_item.setPrice(tb.getPrice());
            tb_order_item.setOrder_id("010"+i);
            tb_order_item.setTotal_fee(tb.getPrice() * json.get(j).getNum());
            tb_order_item.setStatus(status);
            orderMapper.createOrder_item(tb_order_item);
        }
        R.setSuccess("true");
        return R;
    }

    public R findquery(Integer userId,Integer status) {
        List<Tb_order> orderById = orderMapper.findOrderById(userId,status);
        R<List<Tb_order>> r = new R<>();
        r.setObj(orderById);
        r.setSuccess("true");
        return r;
    }

    /**
     * 修改订单状态   因为status为Mysql5.7d的关键字，所以该表可能不太成功，留个笔记
     * @param orderId
     * @param type
     * @return
     */
    public R updateOrderStatus(Integer orderId, Integer type) {
        R<Object> r = new R<>();
        orderMapper.updateOrderStatus(orderId,type);
        r.setSuccess("true");
        return r;
    }
}

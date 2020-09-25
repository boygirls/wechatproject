package com.example.fdl;
import com.example.fdl.common.R;
import com.example.fdl.mapper.*;
import com.example.fdl.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class ZWH_orderService {
    @Autowired
    ZWH_order_Mapper zwh_order_mapper;
    @Autowired
    ZWH_order_item_Mapper zwh_order_item_mapper;
    @Autowired
    goodsMapper goodsMapper;
    @Autowired
    ZWH_order_shipping_Mapper zwh_order_shipping_mapper;


    //生成订单
    public R saveOrder(Integer userId, List<json> json){
        //状态为2表示已付款
        byte status = 2;
        ZWH_order zwh_order = new ZWH_order();
        R<Object> r = new R<>();

        //随机生成订单号
        long orderNum = System.currentTimeMillis();
        String orderId = "10"+(orderNum % 10000);
        LocalDateTime now = LocalDateTime.now();
        zwh_order.setUser_id(userId);
        zwh_order.setOrder_id(orderId);
        zwh_order.setCreate_time(now);
        zwh_order.setStatus(status);
        zwh_order_mapper.createOrder(zwh_order);

        for (int i = 0; i < json.size(); i++){
            ZWH_order_item zwh_order_item = new ZWH_order_item();

            json json1 = json.get(i);
            Integer itemId = json1.getItemId();
            tb_item tb = goodsMapper.queryGoodsById(itemId);
            //通过id判断是否有这个物品(其实这个应该在加入购物车的时候就判断不是吗)
            if (tb == null){
                r.setSuccess("false");
                r.setMsg("please input id");
                return r;
            }
            //这边开始插入
            zwh_order_item.setItem_id(json.get(i).getItemId().toString());//这个是物品id
            zwh_order_item.setOrder_id(orderId);//订单id
            zwh_order_item.setNum(json.get(i).getNum());//物品数量
            zwh_order_item.setTitle(tb.getTitle());//商品描述
            zwh_order_item.setPrice(tb.getPrice());//价格
            zwh_order_item.setTotal_fee(tb.getPrice() * json.get(i).getNum());//总额
            zwh_order_item.setStatus(status);//状态
            zwh_order_item_mapper.createOrderItem(zwh_order_item);
        }


        ZWH_order_shipping zwh_order_shipping = new ZWH_order_shipping();
        zwh_order_shipping.setOrder_id(orderId);
        zwh_order_shipping.setCreated(now);
        //生成快递
        zwh_order_shipping_mapper.createOrderShipping(zwh_order_shipping);
        r.setSuccess("true");
        return r;
    }

    //根据用户Id查找订单
    public R queryOrder(Integer userId){
        List<ZWH_order> list = zwh_order_mapper.orderQueryByUserId(userId);
        R<List<ZWH_order>> r = new R<>();
        r.setObj(list);
        r.setSuccess("true");
        return r;
    }

    //根据订单Id查找订单详情
    public R queryOrderItem(String orderId){
        List<ZWH_order_item> list = zwh_order_item_mapper.orderItemQueryByOrderId(orderId);
        R<List<ZWH_order_item>> r = new R<>();
        r.setObj(list);
        r.setSuccess("true");
        return r;
    }

    //根据订单Id修改订单转态
    public R changeStatus(String orderId,Byte status){
        R<Object> r = new R<>();
       zwh_order_mapper.updateStatusByUserId(orderId,status);
       zwh_order_item_mapper.StatusByOrderId(orderId,status);
       r.setSuccess("true");
       return r;
    }

    //根据订单Id查快递
    public R findOrderShipping(String orderId){
        R<ZWH_order_shipping> r = new R<>();
        ZWH_order_shipping z = zwh_order_shipping_mapper.findOrderShipping(orderId);
        r.setObj(z);
        r.setSuccess("true");
        return r;
    }
}

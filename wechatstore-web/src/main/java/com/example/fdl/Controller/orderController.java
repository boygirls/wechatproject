package com.example.fdl.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.fdl.OrderService;
import com.example.fdl.common.R;
import com.example.fdl.pojo.json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class orderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @PostMapping("/saveOrder")
    public R saveOrder(@RequestBody String orderJson){
        JSONObject jsonObject = JSONObject.parseObject(orderJson);
        System.out.println(jsonObject);

        //取出用户id
        Integer userId = (Integer) jsonObject.get("userId");

        //取出提交上来的商品
        String orderJson2 = jsonObject.getString("orderJson");
        //取出allFlows对应的值,值为字符串
        //使用JSONArray.parseArray(String, Class<T>)将字符串转为指定对象集合


        List<json> jsons = JSONArray.parseArray(orderJson2, json.class);
//        for (json requestPram : jsons) {
//            System.out.println(requestPram.toString());
//        }
        R r = orderService.saveOrder(userId,jsons);
        return r;
    }

    @ResponseBody
    @PostMapping("/query")
    public R findquery(@RequestParam("userId") Integer userId, Integer status){
        System.out.println(userId + " ====" + status);
        R r = orderService.findquery(userId,status);
        return r;
    }



    @PostMapping("/updateOrderStatus")
    @ResponseBody
    public R updateOrderStatus(@RequestParam(value = "orderId")Integer orderId,@RequestParam(value = "type")Integer type){
        R r = orderService.updateOrderStatus(orderId,type);
        return r;
    }

}

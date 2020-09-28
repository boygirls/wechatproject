package com.example.fdl.Controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.fdl.OrderService;
import com.example.fdl.ZWH_orderService;
import com.example.fdl.common.R;
import com.example.fdl.pojo.json;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "新订单接口")
@Controller
@RequestMapping("/order")
public class ZWH_orderController {

    @Autowired
    ZWH_orderService zwh_orderService;

    //生成订单
    @ApiOperation(value = "生成订单")
    @ApiImplicitParam(name = "订单信息",value = "orderJson",dataType = "String",paramType = "body")
    @ResponseBody
    @PostMapping("/ZWH_saveOrder")
    public R saveOrder(@RequestBody String orderJson){
        JSONObject jsonObject = JSONObject.parseObject(orderJson);

        //获得用户id
        Integer userId = (Integer) jsonObject.get("userId");

//        //实付金额
//        Double payment = (Double) jsonObject.get("payment");
//        payment = Double.parseDouble(String.format("%.2f", payment));
//        Integer paymentI = Integer.parseInt(payment.toString()) * 100;
//        String StrPayment = paymentI / 100 + "元" + (paymentI % 100 - paymentI % 10) + "角" + paymentI % 10 + "分";

        //取出提交上来的商品 这里面有物品数量与物品id
        String orderJson2 = jsonObject.getString("orderJson");
        List<json> jsons = JSONArray.parseArray(orderJson2, json.class);

        R r = zwh_orderService.saveOrder(userId,jsons);
        return r;

    }

    //查找订单
    @ApiOperation(value = "查找订单")
    @ApiImplicitParam(name = "userId",value = "用户Id",dataType = "Integer",paramType = "query")
    @ResponseBody
    @PostMapping("/ZWH_queryOrder")
    public R queryOrder(@RequestParam Integer userId){
        R r = zwh_orderService.queryOrder(userId);
        return r;
    }

    //查找订单详情
    @ApiOperation(value = "查找订单详情")
    @ApiImplicitParam(name = "orderId",value = "订单Id",dataType = "String",paramType = "query")
    @ResponseBody
    @PostMapping("/ZWH_queryOrderItem")
    public R queryOrderItem(@RequestParam String orderId){
        R r = zwh_orderService.queryOrderItem(orderId);
        return r;
    }

    //修改订单状态
    @ApiOperation(value = "修改订单状态")
    @ApiImplicitParam(name = "订单信息",value = "orderJson",dataType = "String",paramType = "body")
    @ResponseBody
    @PostMapping("/ZWH_changeStatus")
    public R changeStatus(@RequestBody String orderJson){
        JSONObject jsonObject = JSONObject.parseObject(orderJson);
        String orderId = (String) jsonObject.get("orderId");
        Byte status = (Byte) jsonObject.get("status");

        R r = zwh_orderService.changeStatus(orderId,status);
        return r;
    }


    //根据订单Id查快递
    @ApiOperation(value = "根据订单Id查快递")
    @ApiImplicitParam(name = "orderId",value = "订单Id",dataType = "String")
    @ResponseBody
    @PostMapping("/ZWH_findOrderShipping")
    public R findOrderShipping(String orderId){
        R r = zwh_orderService.findOrderShipping(orderId);
        return r;
    }

}

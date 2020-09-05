package com.example.fdl.Controller;

import com.example.fdl.common.R;
import com.example.fdl.goodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goods")
public class goodsController {


    @Autowired
    private goodsService goodsService;

    @ResponseBody
    @PostMapping("/query")
    public R testAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer rows){
        System.out.println("请求到这了");
        R r = goodsService.findGoodsAll(page, rows);
        return r;
    }

    @ResponseBody
    @GetMapping("/queryGoodsById/{id}")
    public R queryGoodsById(@PathVariable(value = "id") Integer id){
        System.out.println(id);
        R r = goodsService.queryGoodsById(id);
        return r;
    }


}

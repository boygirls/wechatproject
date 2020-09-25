package com.example.fdl.Controller;

import com.example.fdl.common.R;
import com.example.fdl.goodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(tags = "商品接口")
@Controller
@RequestMapping("/goods")
@CrossOrigin(origins = {"http://localhost:8080", "null"})
public class goodsController {


    @Autowired
    private goodsService goodsService;

    @ApiOperation(value = "获取商品列表",notes = "分页查询商品列表，默认一页二十个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页",dataType = "Integer",paramType="query"),
            @ApiImplicitParam(name = "rows",value = "显示个数",dataType = "Integer",paramType="query")
    })
    @ResponseBody
    @PostMapping("/query")
    public R testAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer rows){
        System.out.println("请求到这了");
        R r = goodsService.findGoodsAll(page, rows);
        return r;
    }

    @ApiOperation(value="根据ID查找商品")
    @ApiImplicitParam(name = "id",value = "商品ID",dataType = "Integer",paramType="path")
    @ResponseBody
    @GetMapping("/queryGoodsById/{id}")
    public R queryGoodsById(@PathVariable(value = "id") Integer id){
        System.out.println(id);
        R r = goodsService.queryGoodsById(id);
        return r;
    }


}

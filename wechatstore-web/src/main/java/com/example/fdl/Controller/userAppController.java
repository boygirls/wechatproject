package com.example.fdl.Controller;

import com.example.fdl.common.R;
import com.example.fdl.userAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户登录接口")
@Controller
@RequestMapping("/userApp")
public class userAppController {

    @Autowired
    userAppService userappService;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "name",value = "真实姓名",dataType = "String",paramType="query")
    })
    @PostMapping("/login")
    @ResponseBody
    public R findLoginUser(@RequestParam(value="ausername") String username, @RequestParam(value="name") String name){
        System.out.println("请求到findLoginUser了");
        R r = userappService.findLoginUser(username, name);
        return r;
    }
}

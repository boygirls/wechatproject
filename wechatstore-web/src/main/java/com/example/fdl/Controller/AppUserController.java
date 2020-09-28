package com.example.fdl.Controller;

import com.example.fdl.AppUserService;
import com.example.fdl.common.R;
import com.example.fdl.pojo.TbUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(tags = "用户接口")
@Controller
@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RequestMapping("/app/user")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @ApiOperation(value = "查找用户")
    @ApiImplicitParam( name = "data", value = "用户实体类", required = true, dataType = "TbUser",paramType = "body")
    @PostMapping("/login")
    @ResponseBody
    public R findLoginUser(@RequestBody TbUser data){
        System.out.println("请求到这了");
        System.out.println(data);
        R r = appUserService.findLoginUser(data);
        return r;
    }

}

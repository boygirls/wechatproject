package com.example.fdl.Controller;

import com.example.fdl.AppUserService;
import com.example.fdl.common.R;
import com.example.fdl.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RequestMapping("/app/user")
public class AppUserController {

    @Autowired
    AppUserService appUserService;


    @PostMapping("/login")
    @ResponseBody
    public R findLoginUser(@RequestBody TbUser data){
        System.out.println("请求到这了");
        System.out.println(data);
        R r = appUserService.findLoginUser(data);
        return r;
    }

}

package com.example.fdl.Controller;

import com.example.fdl.common.R;
import com.example.fdl.userAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userApp")
public class userAppController {

    @Autowired
    userAppService userappService;

    @RequestMapping("/login")
    @ResponseBody
    public R findLoginUser(@RequestParam(value="ausername") String username, @RequestParam(value="name") String name){
        System.out.println("请求到findLoginUser了");
        R r = userappService.findLoginUser(username, name);
        return r;
    }
}

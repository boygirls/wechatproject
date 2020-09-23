package com.example.fdl;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class start  extends SpringBootServletInitializer{

    public start() {
        System.out.println("初始化ServletInitializer");
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WechatstoreWebApplication.class);//MyApplication是启动类名
    }
}

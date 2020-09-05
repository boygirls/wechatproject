package com.example.fdl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

//声明为配置类
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控: web.xml, ServletRegistrationBean
    //因为springBoot 内置了 servlet容器，所以没有web.xml, 替代方法： ServletRegistrationBean

    @Bean
    public ServletRegistrationBean  statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录，账号密码设置
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername","root");
        map.put("loginPassword","root");
        map.put("allow","");//允许所有人可以访问
        bean.setInitParameters(map);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //可以过滤哪些请求
        HashMap<String, String> map = new HashMap<>();
        //这些东西不进行统计
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        return bean;
    }
}

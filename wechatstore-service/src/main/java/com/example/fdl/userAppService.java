package com.example.fdl;

import com.example.fdl.common.R;
import com.example.fdl.mapper.userAppMapper;
import com.example.fdl.pojo.tb_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userAppService {

    @Autowired
    userAppMapper userAppMapper;
    private static Integer role_id = 1;

    /**
     * 用户登录,当用户第一次登录。需要在数据库注册该用户
     * @param username
     * @param name  因为是微信用户登录，所以name为真实姓名，去代替数据库里的password字段
     * @return
     */
    public R findLoginUser(String username, String name){
        //判断数据库是否有该用户，没有则创建
        tb_user user = userAppMapper.findByUsername(username);
        if (user == null){
            //没有这个用户则创建这个用户
            userAppMapper.createUsername(username,name, role_id);
        }
        tb_user user2 = userAppMapper.findLoginUser(username,name);
        R<tb_user> r = new R<>();
        r.setObj(user2);
        r.setSuccess("true");
        r.setMsg("成功");
        return r;
    }
}

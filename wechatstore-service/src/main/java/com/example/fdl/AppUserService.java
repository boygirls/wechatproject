package com.example.fdl;


import com.example.fdl.common.ExceptionUtil;
import com.example.fdl.common.R;
import com.example.fdl.mapper.TbUserMapper;
import com.example.fdl.pojo.TbUser;
import com.example.fdl.pojo.TbUserExample;
import com.example.fdl.pojo.TbUserExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {


    @Autowired
    TbUserMapper tbUserMapper;

    public R findLoginUser(TbUser tbUser) {

        R<List<TbUser>> r = new R<>();;
        TbUserExample example = new TbUserExample();
            Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(tbUser.getUsername());
            criteria.andPasswordEqualTo(tbUser.getPassword());
            List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
            if (tbUsers.size() > 0){
                r.setObj(tbUsers);
                r.setMsg("success");
                r.setSuccess("true");
                return r;
            }else{
                r.setSuccess("false");
                r.setStatus(500);
                r.setMsg("用户名或密码错误");
                return r;
            }
    }
}

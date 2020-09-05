package com.example.fdl.mapper;

import com.example.fdl.pojo.tb_user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface userAppMapper {


    tb_user findByUsername(String username);

    void createUsername(String username, String name,Integer role_id);

    tb_user findLoginUser(String username, String name);
}

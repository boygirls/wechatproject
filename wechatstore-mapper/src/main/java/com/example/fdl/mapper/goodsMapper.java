package com.example.fdl.mapper;

import com.example.fdl.pojo.tb_item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface goodsMapper {
    List<tb_item> findGoodsAll(Integer start, Integer end);

    tb_item queryGoodsById(Integer id);
}

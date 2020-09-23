package com.example.fdl;

import com.example.fdl.common.R;
import com.example.fdl.mapper.goodsMapper;
import com.example.fdl.pojo.tb_item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class goodsService {

    @Autowired
    goodsMapper goodsMapper;

    /**
     * 分页查询所有商品
     * @param page
     * @param rows
     * @return
     */
    public R findGoodsAll(Integer page, Integer rows){

        //对要检索行数进行计算，先跑项目，后在计算

        List<tb_item> goodsAll = goodsMapper.findGoodsAll(page, rows);
//        序列化为json
        R<List<tb_item>> tb_itemR = new R<>();
        tb_itemR.setObj(goodsAll);
        tb_itemR.setSuccess("true");
        return tb_itemR;
    }

    /**
     * 根据id来查找商品
     * @param id
     * @return
     */
    public R queryGoodsById(Integer id){
        tb_item good = goodsMapper.queryGoodsById(id);
        R<tb_item> r = new R<>();
        r.setSuccess("true");
        r.setObj(good);
        return r;
    }
}

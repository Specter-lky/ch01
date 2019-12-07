package com.dao;

import com.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("goodsDao")
@Mapper
public interface GoodsDao {
    public List<Goods> selectAllGoods();
    public Goods selectOneGoods(int gno);
    public int addGoods(Goods goods);
    public int updateGoods(Goods goods);
}

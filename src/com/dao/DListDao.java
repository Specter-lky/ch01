package com.dao;

import com.pojo.DList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dlistDao")
@Mapper
public interface DListDao {
    public List<DList> selectAllDList();
    public List<DList> selectOrders(int ono);
    public DList selectoneDList(int dlno);
    public int addDList(DList dList);
    public int updateDList(DList dList);
}

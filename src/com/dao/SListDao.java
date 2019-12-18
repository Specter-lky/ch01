package com.dao;

import com.pojo.SList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("slistDao")
@Mapper
public interface SListDao {
    public List<SList> selectAllSList();
    public SList selectOneSList(int slno);
    public int addSList(SList sList);
    public int updateSList(SList sList);
}

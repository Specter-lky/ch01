package com.dao;

import com.pojo.Salesman;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("salesDao")
@Mapper
public interface SalesDao {
    public Salesman login(Salesman salesman);
    public List<Salesman> selectAllSalesman();
    public Salesman selectOneSalesman(int sno);
    public int addSalesman(Salesman salesman);
    public int updateSalesman(Salesman salesman);
}

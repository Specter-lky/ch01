package com.dao;

import com.pojo.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contractDao")
@Mapper
public interface ContractDao {
    public List<Contract> selectAllContract();
    public Contract selectOneContract(int ctno);
    public List<Contract> selectSalesContract(String sname);
    public int addContract(Contract contract);
    public int updateContract(Contract contract);
}

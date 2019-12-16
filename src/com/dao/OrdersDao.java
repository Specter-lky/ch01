package com.dao;

import com.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ordersDao")
@Mapper
public interface OrdersDao {
    public List<Orders> selectAllOrders();
    public List<Orders> selectContractOrders(int ctno);
    public Orders selectOneOrders(int ono);
    public int addOrders(Orders orders);
    public int updateOrders(Orders orders);
    public List<Orders> selectOrdersAndDList(int ono);
}

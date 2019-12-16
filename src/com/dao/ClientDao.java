package com.dao;

import com.pojo.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientDao")
@Mapper
public interface ClientDao {
    public List<Client> selectAllClient();
    public Client selectOneClient(String cname);
    public int addClient(Client client);
    public int updateClient(Client client);
}

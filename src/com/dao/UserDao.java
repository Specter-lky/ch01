package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao {
    public User login(User user);
}

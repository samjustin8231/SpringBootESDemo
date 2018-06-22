package com.example.esdemo.service;

import com.example.esdemo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2018/6/21 19:20
 */
@Repository
public interface UserMapper {

    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(@Param("id") Integer id, @Param("user") User user);

    public int delete(Integer id);
}

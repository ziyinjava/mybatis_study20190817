package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.domain.User2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User2> findAll() throws IOException;

    public User findById(int id);

    int countUsers();

    // 查询id=3或者名字中包括xx
    /*List<User> findUserByIdORUsername(@Param("abc") int id , @Param("xyz") String username);*/
    List<User> findUserByIdORUsername(Map<String,Object> mm);

    List<String> findUserNames();

    List<Map<String,Object>> findUserMaps();

    Map<String,Object> findUserMapByID(int id);

    void insertUser(User user);

}

package com.itheima.service;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo {

    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //sqlSession.selectList("userMapper.selectAll");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User2> all = mapper.findAll();
        System.out.println(all);

        /*User user = mapper.findById(1);
        System.out.println(user);*/

        /*int i = mapper.countUsers();
        System.out.println(i);*/

        /*List<User> userByIdORUsername = mapper.findUserByIdORUsername(3, "%xx%");*/
        /*Map<String,Object> mm = new HashMap<String, Object>();
        mm.put("aa",3);
        mm.put("bb","%xx%");
        List<User> userByIdORUsername = mapper.findUserByIdORUsername(mm);*/

        /*System.out.println(userByIdORUsername);*/

        /*List<String> userNames = mapper.findUserNames();
        System.out.println(userNames);*/

        /*List<Map<String, Object>> userMaps = mapper.findUserMaps();
        System.out.println(userMaps);*/

        /*Map<String, Object> userMapByID = mapper.findUserMapByID(3);
        System.out.println(userMapByID);*/

        /*User user = new User();
        user.setUsername("opp");
        user.setPassword("opp");
        System.out.println("保存前: "+user);
        mapper.insertUser(user);
        System.out.println("保存后: "+user);*/
    }

}

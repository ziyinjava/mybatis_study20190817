package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.bo.User;
import com.itheima.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author ziyin
 @create 2019-06-2019/6/29-7:16
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        //相对于类加载路径
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //参数 :namespace+id
        List<User> userList = sqlSession.selectList("com.itheima.dao.UserDao.findAll");
        //这种方式PageHelper 不起作用,
        PageHelper.startPage(1,3);
        //打印数据
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void  test2(){
        User user = new User();
        user.setUsername("zi");
        user.setBirthday(new Date());
        user.setAddress("xx");
        user.setSex("男");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //参数 :namespace+id
        int insert = sqlSession.insert("com.itheima.dao.UserDao.save",user);
        System.out.println(insert);
        //事务提交, 才能持久化到磁盘
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void  test3(){
        User user = new User();
        user.setId(51);
        user.setUsername("zzzzzi");
        user.setBirthday(new Date());
        user.setAddress("xx");
        user.setSex("男");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //参数 :namespace+id
        int insert = sqlSession.insert("com.itheima.dao.UserDao.update",user);
        System.out.println(insert);
        //事务提交, 才能持久化到磁盘
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void  test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //参数 :namespace+id
        int insert = sqlSession.delete("com.itheima.dao.UserDao.delete",52);
        System.out.println(insert);
        //事务提交, 才能持久化到磁盘
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //参数 :namespace+id

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.getUserById(53);
        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void test6(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //参数 :namespace+id

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User condition = new User();
        condition.setUsername("播");
        List<User> user = userDao.getUserByCondition(condition);
        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void test7(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //参数 :namespace+id
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<Integer> ids = Arrays.asList(41, 42, 43);
        List<User> user = userDao.getUserByIds(ids);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test8(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //参数 :namespace+id
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //动态代理的这种方式,PageHelper拦截插件才起作用
        PageHelper.startPage(1,3);
        List<User> userList = userDao.findAll();
        System.out.println(userList);

        PageInfo pageInfo = new PageInfo(userList);
        System.out.println("当前页: " + pageInfo.getPageNum());
        System.out.println("每页显示条数: " + pageInfo.getPageSize());
        System.out.println("总条数: " + pageInfo.getTotal());
        System.out.println("总页数: " + pageInfo.getPages());
        System.out.println("上一页: " + pageInfo.getPrePage());
        System.out.println("下一页: " + pageInfo.getNextPage());
        System.out.println("是否是第一页: " + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页: " +  pageInfo.isIsLastPage());
        sqlSession.close();
    }


}

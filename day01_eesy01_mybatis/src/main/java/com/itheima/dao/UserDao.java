package com.itheima.dao;

        import com.itheima.bo.User;

        import java.util.List;

/**
 * @author ziyin
 @create 2019-06-2019/6/29-5:40
 */
public interface UserDao {

    List<User> findAll();

    User getUserById(int id);

    List<User> getUserByCondition(User user);

    List<User> getUserByIds(List<Integer> ids);
}

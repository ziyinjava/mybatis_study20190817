package com.ziyin.ssm.dao;


import com.ziyin.ssm.bo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 帐户dao接口
 */
public interface AccountDao {

    // 查询所有账户
    @Select("select * from account")
     List<Account> findAll();

    // 保存帐户信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
     void saveAccount(Account account);

}

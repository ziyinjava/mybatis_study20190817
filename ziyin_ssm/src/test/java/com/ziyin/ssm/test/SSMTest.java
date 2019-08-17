package com.ziyin.ssm.test;
import com.ziyin.ssm.bo.Account;
import com.ziyin.ssm.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ziyin
 @create 2019-07-2019/7/2-23:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SSMTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll(){
        List<Account> acccountList = accountService.findAll();
        System.out.println(acccountList);
    }

    @Test
    public void testSave(){
        accountService.saveAccount(new Account("hehe",11111.0));
    }

}

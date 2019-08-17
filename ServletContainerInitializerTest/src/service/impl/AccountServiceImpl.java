package service.impl;


import bo.Account;
import service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {


    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户...");
        return null;
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
    }
}

package com.udemy.aopdemo.dao;

import com.udemy.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

}

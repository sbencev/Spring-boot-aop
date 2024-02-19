package com.udemy.aopdemo.dao;

import com.udemy.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");

        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {

        return findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        List<Account> myAccounts = new ArrayList<>();

        if (tripWire) {

            throw new RuntimeException("Exception triggered!");

        }

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Bence", "Platinum");
        Account temp3 = new Account("Peter", "Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;

    }
}

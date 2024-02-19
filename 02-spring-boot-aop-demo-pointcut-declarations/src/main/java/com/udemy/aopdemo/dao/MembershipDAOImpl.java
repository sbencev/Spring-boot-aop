package com.udemy.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addRandomAccount() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP");

        return true;
    }

    @Override
    public void goToSleep() {

        System.out.println(getClass() + ": Going to sleep...");

    }
}

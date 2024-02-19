package com.udemy.aopdemo;

import com.udemy.aopdemo.dao.AccountDAO;
import com.udemy.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO thMembershipDAO) {

        return runner -> {

            demoTheBeforeAdvice(theAccountDAO, thMembershipDAO);

        };

    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO thMembershipDAO) {

        Account myAccount = new Account();

        theAccountDAO.addAccount(myAccount, true);

        theAccountDAO.doWork();

        thMembershipDAO.addRandomAccount();

        thMembershipDAO.goToSleep();

    }

}

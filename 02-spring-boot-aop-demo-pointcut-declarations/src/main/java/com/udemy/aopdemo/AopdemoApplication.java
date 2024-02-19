package com.udemy.aopdemo;

import com.udemy.aopdemo.dao.AccountDAO;
import com.udemy.aopdemo.dao.MembershipDAO;
import com.udemy.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO thMembershipDAO,
                                               TrafficFortuneService theTrafficFortuneService) {

        return runner -> {

            demoTheAroundAdviceRethrowException(theTrafficFortuneService);

            //demoTHeAroundAdviceHandleException(theTrafficFortuneService);

            //demoTheAroundAdvice(theTrafficFortuneService);

            //demoAfterAdvice(theAccountDAO);

            //demoTheAfterThrowingAdvice(theAccountDAO);

            //demoTheAfterReturningAdvice(theAccountDAO);

            //demoTheBeforeAdvice(theAccountDAO, thMembershipDAO);

        };

    }

    private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");

        System.out.println("Calling getFortune()");

        boolean tripWire = true;

        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished!");

    }

    private void demoTHeAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\nMain Program: demoTHeAroundAdviceHandleException");

        System.out.println("Calling getFortune()");

        boolean tripWire = true;

        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished!");

    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\nMain Program: demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        String data = theTrafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished!");

    }

    private void demoAfterAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = null;

        try {

            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);

        } catch (Exception exception) {

            System.out.println("\n\nMain Program: ... caught exception" + exception);

        }

        System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = null;

        try {

            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);

        } catch (Exception exception) {

            System.out.println("\n\nMain Program: ... caught exception" + exception);

        }

        System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO thMembershipDAO) {

        Account myAccount = new Account();
        myAccount.setName("Bence");
        myAccount.setLevel("Platinum");

        theAccountDAO.addAccount(myAccount, true);

        theAccountDAO.doWork();

        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();


        thMembershipDAO.addRandomAccount();

        thMembershipDAO.goToSleep();

    }

}

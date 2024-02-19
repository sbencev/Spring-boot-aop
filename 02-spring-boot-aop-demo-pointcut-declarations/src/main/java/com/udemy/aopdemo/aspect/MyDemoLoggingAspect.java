package com.udemy.aopdemo.aspect;

import com.udemy.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.udemy.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        String method = theProceedingJoinPoint.getSignature().toString();

        System.out.println("\n========>>> Executing @After (finally) on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            theProceedingJoinPoint.proceed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());

            throw exception;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n===========> Duration: " + duration / 1000 + " seconds");

        return result;

    }

    @After("execution(* com.udemy.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        String method = theJoinPoint.getSignature().toString();

        System.out.println("\n========>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.udemy.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exception) {

        String method = theJoinPoint.getSignature().toString();

        System.out.println("\n========>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n========>>> The exception is: " + exception);

    }

    @AfterReturning(pointcut = "execution(* com.udemy.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        String method = theJoinPoint.getSignature().toString();

        System.out.println("\n========>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n========>>> result is: " + result);

        convertAccountToUpperCase(result);

        System.out.println("\n========>>> result is: " + result);

    }

    private void convertAccountToUpperCase(List<Account> result) {

        for (Account tempAccount : result) {

            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);

        }

    }

    @Before("com.udemy.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on addAccount");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {

            System.out.println(tempArg);

            if (tempArg instanceof Account) {

                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());

            }

        }

    }

}

package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    private static int numberVisit=0;

    @Pointcut("execution(* com.codegym.controller.BookController.*(..)))")
    public void allMethodBookController(){};

    @After("allMethodBookController()")
    public void log(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("Ban da thuc hien goi: %s.%s%s", className, method, args));
    }

    @Pointcut("execution(* com.codegym.controller.BookController.listBook(..)))")
    public void showCreateOder(){};

    @After("showCreateOder()")
    public void logNumberVisit(JoinPoint joinPoint) {
        Logger.numberVisit++;
        System.out.println("So luong nguoi da ghe tham thu vien: "+Logger.numberVisit);
    }
}

package com.example.practice1.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
@Aspect
@Component
public class Logger {
    @Pointcut("execution(* com.example.practice1.controller.CustomerController.show*(..))")
    public void allMethodPointCut(){

    }
    @Before("allMethodPointCut()")
    public void log(JoinPoint joinPoint){
        System.out.println("Start method name:"+joinPoint.getSignature().getName()+"Time"+ LocalDate.now());
    }

}

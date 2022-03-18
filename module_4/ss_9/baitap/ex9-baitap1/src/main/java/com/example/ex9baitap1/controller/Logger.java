package com.example.ex9baitap1.controller;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class Logger {
    @Pointcut(value = "within(com.example.ex9baitap1.controller.*)")
    public void allMethodPointCut() {

    }

    @Before("allMethodPointCut()")
    public void log(JoinPoint joinPoint) {
        System.out.println("Start method name:"+joinPoint.getSignature().getName()+"Time"+ LocalDate.now());
    }
}

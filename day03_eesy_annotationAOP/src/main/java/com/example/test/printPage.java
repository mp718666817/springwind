package com.example.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("printpage")
@Aspect
public class printPage {
    /**
     * 匹配servivce类下面的所有方法
     */
    @Before("")
    public void before(){
        System.out.println("before");
    }
    public void after(){
        System.out.println("after");
    }
    public void error(){
        System.out.println("error");
    }
    public void finall(){
        System.out.println("finall");
    }
    @Pointcut("execution(* com.example.service.impl.*.*(..))")
    public void pt1(){}

    @Around("pt1()")
    public Object arroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        Object[] args = pjp.getArgs();
        try {
            System.out.println("环绕类开始记录日志了，前置");
            rtValue = pjp.proceed(args);
            System.out.println(rtValue);
            System.out.println("环绕类开始记录日志了，后置");
        } catch (Throwable throwable) {
            System.out.println("环绕类开始记录日志了，异常");
            throwable.printStackTrace();
        }finally {
            System.out.println("环绕类开始记录日志了，最终");
        }
        return rtValue;

    }
}

package com.vansh.spring.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExp {

    @Pointcut("execution(* com.vansh.spring.demo.*.*(..))")
    public void forControllerPackage(){}

    @Pointcut("execution(* com.vansh.spring.demo.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.vansh.spring.demo.*.set*(..))")
    public  void setter(){}

    @Pointcut("forControllerPackage() && !(getter() || setter())")
    public void forControllerPackageNoGetSet(){}


}

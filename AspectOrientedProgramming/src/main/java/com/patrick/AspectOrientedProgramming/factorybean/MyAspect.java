package com.patrick.AspectOrientedProgramming.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        checkPermissions();
        Object obj = methodInvocation.proceed();
        recordLog();
        return obj;
    }

    public void checkPermissions(){
        System.out.println("check permissions");
    }

    public void recordLog(){
        System.out.println("record log");
    }
}

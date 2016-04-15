package com.wiseq.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
public class LoggingAspect {
	
	public void declareJointPointExpression(){}
	
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+args);
	}
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" ends ");
	}
	
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends result "+result);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs with "+e);
	}
	
}

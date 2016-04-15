package com.wiseq.aop.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面:把该类放入到IOC容器中、再将此类声明为一个切面

//@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * 定义一个方法，用于声明切入点表达式。 一般地，该方法中再不需要添入其他的代码
	 */
	@Pointcut("execution(int com.wiseq.aop.impl.ArthmeticCalculatorImpl.*(.. ))")
	public void declareJoinPointExpression(){
		
	}
	
	
	//声明该方法是一个前置通知：在目标方法执行之前执行
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object>  args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method "+methodName+" begins "+args);
	}
	
	
	//后置通知:在目标方法执行之后(无论是否发生异常)，执行的通知
	//在后置通知中还不能访问目标方法执行的结果
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	//返回通知
	/**
	 * 在方法正常执行结束后的代码
	 * 返回通知是可以访问到方法的返回值的
	 */
	@AfterReturning(value="declareJoinPointExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends  with "+result);
	}
	
	/**
	 * 在目标方法出现异常时，会执行的代码
	 * 可以访问到异常对象；且可以指定在出现特定异常时在执行通知代码
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint ,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception : "+ex);
	}
	
	
	
}

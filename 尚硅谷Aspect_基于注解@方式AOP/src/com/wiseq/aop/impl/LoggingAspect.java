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

//�����������Ϊһ������:�Ѹ�����뵽IOC�����С��ٽ���������Ϊһ������

//@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * ����һ�����������������������ʽ�� һ��أ��÷������ٲ���Ҫ���������Ĵ���
	 */
	@Pointcut("execution(int com.wiseq.aop.impl.ArthmeticCalculatorImpl.*(.. ))")
	public void declareJoinPointExpression(){
		
	}
	
	
	//�����÷�����һ��ǰ��֪ͨ����Ŀ�귽��ִ��֮ǰִ��
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object>  args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The Method "+methodName+" begins "+args);
	}
	
	
	//����֪ͨ:��Ŀ�귽��ִ��֮��(�����Ƿ����쳣)��ִ�е�֪ͨ
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	//����֪ͨ
	/**
	 * �ڷ�������ִ�н�����Ĵ���
	 * ����֪ͨ�ǿ��Է��ʵ������ķ���ֵ��
	 */
	@AfterReturning(value="declareJoinPointExpression()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends  with "+result);
	}
	
	/**
	 * ��Ŀ�귽�������쳣ʱ����ִ�еĴ���
	 * ���Է��ʵ��쳣�����ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="declareJoinPointExpression()",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint ,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occurs exception : "+ex);
	}
	
	
	
}

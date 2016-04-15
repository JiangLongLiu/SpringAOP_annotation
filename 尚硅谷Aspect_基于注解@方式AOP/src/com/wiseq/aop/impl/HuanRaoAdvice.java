package com.wiseq.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 环绕通知比较特殊，专门拿出来说
 * @Order 注解指定切面的优先级，值越小优先级越高
 * @author liujl
 *
 */
@Order(2)
@Aspect
@Component
public class HuanRaoAdvice {
	
	/**
	 * 环绕通知--功能最强大，却不是最常用
	 * 需要携带ProceedingJoinPoint 类型的参数
	 * 环绕通知类似于动态代理的全过程:ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	@Around(value="com.wiseq.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		//执行目标方法
		Object result=null;
		String methodName=pjd.getSignature().getName();
		List<Object> args=Arrays.asList(pjd.getArgs());
		try {
			//前置通知
			System.out.println("The method "+methodName+" begins with "+args);
			result=pjd.proceed();
			//返回通知
			System.out.println("The method "+methodName+" result "+result);
			
		} catch (Throwable e) {
			e.printStackTrace();
			//例外通知
			System.out.println("The method "+methodName+" occours with "+e);
		}finally{
			//后置通知
			System.out.println("The method "+methodName+" ends");
		}
		return result;
	}
}

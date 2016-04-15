package com.wiseq.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidatorAspect {
	
	@Before("com.wiseq.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public void validate(JoinPoint joinPoint){
		System.out.println("Validate with "+Arrays.asList(joinPoint.getArgs()));
	}
}

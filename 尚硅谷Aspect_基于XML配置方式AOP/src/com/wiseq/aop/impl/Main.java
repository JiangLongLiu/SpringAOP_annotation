package com.wiseq.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		ArithmeticCalculator arithmicCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		System.out.println(arithmicCalculator.getClass().getName());
	
		arithmicCalculator.add(1, 1);
		arithmicCalculator.sub(2, 1);
		arithmicCalculator.mul(2, 2);
		arithmicCalculator.div(2, 2);
	}

}

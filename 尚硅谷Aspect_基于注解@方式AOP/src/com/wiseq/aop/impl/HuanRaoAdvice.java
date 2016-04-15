package com.wiseq.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * ����֪ͨ�Ƚ����⣬ר���ó���˵
 * @Order ע��ָ����������ȼ���ֵԽС���ȼ�Խ��
 * @author liujl
 *
 */
@Order(2)
@Aspect
@Component
public class HuanRaoAdvice {
	
	/**
	 * ����֪ͨ--������ǿ��ȴ�������
	 * ��ҪЯ��ProceedingJoinPoint ���͵Ĳ���
	 * ����֪ͨ�����ڶ�̬�����ȫ����:ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 */
	@Around(value="com.wiseq.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		//ִ��Ŀ�귽��
		Object result=null;
		String methodName=pjd.getSignature().getName();
		List<Object> args=Arrays.asList(pjd.getArgs());
		try {
			//ǰ��֪ͨ
			System.out.println("The method "+methodName+" begins with "+args);
			result=pjd.proceed();
			//����֪ͨ
			System.out.println("The method "+methodName+" result "+result);
			
		} catch (Throwable e) {
			e.printStackTrace();
			//����֪ͨ
			System.out.println("The method "+methodName+" occours with "+e);
		}finally{
			//����֪ͨ
			System.out.println("The method "+methodName+" ends");
		}
		return result;
	}
}

package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CloudAspect {
	
	@Before("com.spring.aop.aspect.LoggingAspect.daoAccountExcludeSetterGetter()")
	public void addBeforeAdvice()
	{
		System.out.println("\n-----> executing before advice on addAccount() Cloud Aspect excluding gett"
				+ "er setter");
	}


}

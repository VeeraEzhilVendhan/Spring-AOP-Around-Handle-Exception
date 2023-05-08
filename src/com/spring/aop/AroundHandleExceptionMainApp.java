package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.service.FortuneService;

public class AroundHandleExceptionMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=
				new	AnnotationConfigApplicationContext(AopConfig.class);
		
		
        FortuneService fortuneservice=
        		context.getBean("fortuneService",FortuneService.class);
	
        boolean tripwire=true;
        System.out.println(fortuneservice.getFortune(tripwire));
        
        System.out.println("main app");
        context.close();
	
	}

}

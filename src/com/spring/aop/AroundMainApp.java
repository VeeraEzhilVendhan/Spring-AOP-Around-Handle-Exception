package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.service.FortuneService;

public class AroundMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=
				new	AnnotationConfigApplicationContext(AopConfig.class);
		
		AccountDAO accoutDAO=context.getBean("accountDAO",AccountDAO.class);
		
        FortuneService fortuneservice=
        		context.getBean("fortuneService",FortuneService.class);
	
        System.out.println(fortuneservice.getFortune());
        
        System.out.println("main app");
        context.close();
	
	}

}

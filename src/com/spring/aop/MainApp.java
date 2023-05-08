package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.Account;
import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;

public class MainApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=
				new	AnnotationConfigApplicationContext(AopConfig.class);
		
		AccountDAO accoutDAO=context.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		Account a=new Account(0,"");

		accoutDAO.addAccount(a);
		
		accoutDAO.getName();
		
		membershipDAO.addAccount();
		
		context.close();
	
	
	}
	
	
	
	

}

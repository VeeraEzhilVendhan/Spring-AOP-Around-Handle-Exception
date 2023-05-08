package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//this is where we add all of our related advices for logging
//	@Before("execution(public void addAccount())")
//	public void addAccountBeforeAdvice()
//	{
//		System.out.println("\n-----> executing before advice on addAccount()");
//	}
	
//	@Before("execution(public void com.spring.aop.dao.MembershipDAO.addAccount())")
//	public void memeberShipBeforeAdvice()
//	{
//		System.out.println("\n-----> executing before advice on MembershipAccountDAO addAccount()");
//	}
	
//	@Before("execution(public * *(com.spring.aop.dao.Account))")
//	public void addBeforeAdvice()
//	{
//		System.out.println("\n-----> executing before advice on addAccount(Account)");
//	}
	
	//Pointcut declaration
	@Pointcut("execution(public * *(com.spring.aop.dao.Account))")
	public void daoAccount() {}
	
//	@Before("daoAccount()")
//	public void addBeforeAdvice()
//	{
//		System.out.println("\n-----> executing before advice on addAccount(Account)");
//	}
	
	@Pointcut("execution(public * com.spring.aop.dao.Account.set*(..))")
	public void setMethod() {}
	
   	@Pointcut("execution(public * com.spring.aop.dao.Account.get*(..))")
	public void getMethod() {}
	
	@Pointcut("daoAccount() && !(getMethod() || setMethod())")
	public void daoAccountExcludeSetterGetter() {}
	

}

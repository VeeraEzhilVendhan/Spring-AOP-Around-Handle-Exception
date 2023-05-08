package com.spring.aop.aspect;

import java.util.logging.Logger;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aop.dao.Account;

@Aspect
@Component
@Order(2)
public class LogAspect {
	
	private Logger mylogger=Logger.getLogger(getClass().getName());
	
	
	@Before("com.spring.aop.aspect.LoggingAspect.daoAccountExcludeSetterGetter()")
	public void addBeforeAdvice(JoinPoint joinPoint)
	{
		System.out.println("\n-----> executing before advice on addAccount() excluding gett"
				+ "er setter");
		
		//display method signature
		MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
		
		System.out.println(methodSignature);
		
		//display method args
		Object[] args=joinPoint.getArgs();
		
		for(int i=0;i<args.length;i++)
		{
			System.out.println("method args"+args[i]);
			if(args[i] instanceof Account)
			{
				Account a=(Account) args[i];
				System.out.println(a.getNo()); 
				System.out.println(a.getName());
			}
		}	
	}
	
	@AfterReturning(pointcut="execution(* findAccount(..))",returning="result")
	public void afterReturningFindAccount(JoinPoint joinPoint, List<Account> result)
	{
		String method=joinPoint.getSignature().toShortString();
		System.out.println("after returning advice method"+method);
		System.out.println("after returning advice result"+result);
	}
	
	@AfterThrowing(pointcut="execution(* findAccount(..))",throwing="theExc")
	public void afterThrowingFindAccount(JoinPoint joinPoint,Throwable theExc)
	{
		System.out.println("after throwing advice");
		String method=joinPoint.getSignature().toShortString();
		System.out.println("after throwing advice method"+ method);
		System.out.println("after throwing advice Exception"+ theExc);
		
	}
	
	@After("execution(* findAccount(..))")
	public void afterFindAccount(JoinPoint joinPoint)
	{
		String method=joinPoint.getSignature().toShortString();
		System.out.println("after advice method"+ method);
		System.out.println("after advice");
	}
	
	//Handle Exception
/*	@Around("execution(* getFortune(..))")
	public Object aroundFortune(ProceedingJoinPoint proJoinPoint) throws Throwable
	{
		String method=proJoinPoint.getSignature().toShortString();
		System.out.println("around advice method"+ method);	
		long begin=System.currentTimeMillis();
		Object result=null;
		try
		{
			result=proJoinPoint.proceed();
		}
		catch(Exception exc)
		{
			//log the exception
			mylogger.warning(exc.getMessage());
			//give custom error msg
			result="Exception Thrown";
		}
		
		long end = System.currentTimeMillis();
		long timeTaken=end-begin;
		System.out.println("around advice "+timeTaken/1000.00+" seconds");
		return result;
	} */
	
	//ReThrow Exception
	@Around("execution(* getFortune(..))")
	public Object aroundFortune1(ProceedingJoinPoint proJoinPoint) throws Throwable
	{
		String method=proJoinPoint.getSignature().toShortString();
		System.out.println("around advice method"+ method);	
		long begin=System.currentTimeMillis();
		Object result=null;
		try
		{
			result=proJoinPoint.proceed();
		}
		catch(Exception exc)
		{
			//log the exception
			mylogger.warning(exc.getMessage());
			//rethrow the exception
			throw exc;
		}
		
		long end = System.currentTimeMillis();
		long timeTaken=end-begin;
		System.out.println("around advice "+timeTaken/1000.00+" seconds");
		return result;
	}
    
}

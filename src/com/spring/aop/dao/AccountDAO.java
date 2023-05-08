package com.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount(Account a)
	{
		System.out.println(getClass()+" Doing DB work adding account");
	}
	
	String name;

	public String getName() {
		System.out.println("this is get method");
		return name;
	}

	public void setName(String name) {
		System.out.println("this is set method");
		this.name = name;
	}
	
	public List<Account> findAccount(boolean b)
	{
		if(b)
		{
			throw new RuntimeException("manualy created exception");
		}
		List<Account> list=new ArrayList<Account>();
		Account account1=new Account(1,"A");
		Account account2=new Account(2,"B");
		Account account3=new Account(3,"C");
		
		list.add(account1);
		list.add(account2);
		list.add(account3);
		
		return list;
	}
	

}

package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount()
	{
		System.out.println(getClass()+" Doing DB work membership account");
	}

}

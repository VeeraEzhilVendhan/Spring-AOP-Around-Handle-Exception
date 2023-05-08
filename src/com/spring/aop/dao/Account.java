package com.spring.aop.dao;

public class Account {
	
	int no;
	String name;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account(int no, String name) {
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Account [no=" + no + ", name=" + name + "]";
	}
	
	
	

}

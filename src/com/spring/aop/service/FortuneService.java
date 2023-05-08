package com.spring.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {

	public String getFortune() {
		// simulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "good day";
	}

	public String getFortune(boolean tripwire) {
		if (tripwire) {
			throw new RuntimeException("Manualy created Exception");
		}
		return getFortune();
	}
}

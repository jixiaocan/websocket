package com.i_transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.i_transaction.service.BankService;


public class App {

	static ApplicationContext ac = new ClassPathXmlApplicationContext("beans_i.xml");

	@Test
	public void transferAccounts() {
		BankService bankService=(BankService)ac.getBean("bankService");
		bankService.transferAccounts(50, 1, 2);
	}
	
	

}

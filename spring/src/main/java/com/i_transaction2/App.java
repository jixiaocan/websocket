/**
 * 
 */
package com.i_transaction2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.i_transaction.service.BankService;

/**
 * 
 * @author xiaocan
 * 2017年6月21日
 */
public class App {
	static ApplicationContext ac = new ClassPathXmlApplicationContext("beans_i.xml");

	@Test
	public void transferAccounts() {
		BankService bankService=(BankService)ac.getBean("bankService");
		bankService.transferAccounts(50, 1, 2);
	}
}

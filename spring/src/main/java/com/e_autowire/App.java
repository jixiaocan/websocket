package com.e_autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author xiaocan
 * 2017年6月6日
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_e.xml");
		
		People people = (People) ac.getBean("people1");
		
		System.out.println(people.toString());
	}
}

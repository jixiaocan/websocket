package com.a_hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
//		HelloWorld helloWorld=(HelloWorld)ac.getBean("helloWorld");
		HelloWorld helloWorld = ac.getBean(HelloWorld.class);
		helloWorld.say();
	}
}

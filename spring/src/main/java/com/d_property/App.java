package com.d_property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_d.xml");
		// 基本类型值
		People people=(People)ac.getBean("people1");
		System.out.println(people);
		// 注入bean
		people=(People)ac.getBean("people2");
		System.out.println(people);
		// 内部bean
		people=(People)ac.getBean("people3");
		System.out.println(people);
		// 注入null
		people=(People)ac.getBean("people4");
		System.out.println(people);
		/*// 级联属性
		people=(People)ac.getBean("people5");
		System.out.println(people);*/
		// 注入集合
		people=(People)ac.getBean("people6");
		System.out.println(people);
	}
}

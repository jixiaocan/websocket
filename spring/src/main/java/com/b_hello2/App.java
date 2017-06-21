package com.b_hello2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author xiaocan 2017年6月5日
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		JavaWork javaWork = (JavaWork) ac.getBean("javaWork");
		javaWork.doTest();
	}
}

/**
 * 
 */
package com.g_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author xiaocan 2017年6月6日
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_g.xml");
		StudentService studentService = (StudentService) ac.getBean("studentService");
		studentService.addStudent("张三");
	}
}

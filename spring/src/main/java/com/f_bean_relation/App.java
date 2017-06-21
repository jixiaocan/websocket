/**
 * 
 */
package com.f_bean_relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author xiaocan
 * 2017年6月6日
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans_f.xml");
		
		People zhangsan=(People)ac.getBean("zhangsan");
		System.out.println(zhangsan);
		
		People lisi=(People)ac.getBean("lisi");
		System.out.println(lisi);
		System.out.println(lisi.getDog().getName());
	}
}

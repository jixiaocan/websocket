package com.a_hello;

import org.springframework.context.annotation.Bean;


public class HelloWorld {
	@Bean
	public void say(){
		System.out.println("Spring4你好");
	}
}

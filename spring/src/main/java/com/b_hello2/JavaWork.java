package com.b_hello2;

public class JavaWork {
	
	private Tester tester;
	
	public void setTester(Tester tester) {
		this.tester = tester;
	}

	public void doTest(){
		tester.test();
	}
}

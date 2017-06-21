package com.c_createBean;

public class PeopleFactory {

	public People createPeople(){
		People p=new People();
		p.setId(5);
		p.setName("zhangsan");
		p.setAge(77);
		return p;
	}
}

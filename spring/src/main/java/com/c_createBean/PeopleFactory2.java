package com.c_createBean;

public class PeopleFactory2 {

	public static People createPeople(){
		People p=new People();
		p.setId(8);
		p.setName("lisi");
		p.setAge(88);
		return p;
	}
}

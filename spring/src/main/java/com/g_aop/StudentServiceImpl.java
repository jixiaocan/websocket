package com.g_aop;

public class StudentServiceImpl implements StudentService {

	public void addStudent(String name) {
		System.out.println("添加学生" + name);
	}

}

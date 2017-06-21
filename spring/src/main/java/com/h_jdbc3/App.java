/**
 * 
 */
package com.h_jdbc3;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.h_jdbc3.model.Student;
import com.h_jdbc3.service.StudentService;


/**
 * 
 * @author xiaocan
 * 2017年6月6日
 */
public class App {
	static StudentService studentService = null;
	static{
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans_h3.xml");
		studentService = (StudentService) ac.getBean("studentService");
	}

	@Test
	public void addStudent(){
		int addNums = studentService.addStudent(new Student("王五",1));
		Assert.assertTrue("添加成功", addNums == 1);
	}
	
	@Test
	public void updateStudent(){
		int updateNums = studentService.updateStudent(new Student(13,"王五2",2));
		Assert.assertTrue("更新成功",updateNums == 1);
	}
	
	@Test
	public void deleteStudent(){
		int deleteNums = studentService.deleteStudent(9);
		Assert.assertTrue("删除成功",deleteNums == 1);
	}
	@Test
	public void findStudents(){
		List<Student> studentList = studentService.findStudents();
		for(Student student : studentList){
			System.out.println(student);
		}
	}
}

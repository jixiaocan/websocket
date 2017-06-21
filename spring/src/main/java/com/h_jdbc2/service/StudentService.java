/**
 * 
 */
package com.h_jdbc2.service;

import java.util.List;

import com.h_jdbc2.model.Student;

/**
 * 
 * @author xiaocan
 * 2017年6月15日
 */
public interface StudentService {
	public int addStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudent(int id);

	public List<Student> findStudents();
}

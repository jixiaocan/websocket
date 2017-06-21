/**
 * 
 */
package com.h_jdbc.service;

import java.util.List;

import com.h_jdbc.model.Student;

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

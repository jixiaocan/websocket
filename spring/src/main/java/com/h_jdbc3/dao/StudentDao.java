/**
 * 
 */
package com.h_jdbc3.dao;

import java.util.List;

import com.h_jdbc3.model.Student;

/**
 * 
 * @author xiaocan 2017年6月6日
 */
public interface StudentDao {
	public int addStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudent(int id);

	public List<Student> findStudents();
}

/**
 * 
 */
package com.h_jdbc3.service.impl;

import java.util.List;

import com.h_jdbc3.dao.StudentDao;
import com.h_jdbc3.model.Student;
import com.h_jdbc3.service.StudentService;

/**
 * @author xiaocan
 * 2017年6月15日
 */
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao){
		this.studentDao = studentDao;
	}
	
	public int addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public int deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}

	public List<Student> findStudents() {
		return studentDao.findStudents();
	}
}

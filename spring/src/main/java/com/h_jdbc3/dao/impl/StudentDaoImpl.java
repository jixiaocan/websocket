/**
 * 
 */
package com.h_jdbc3.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.h_jdbc3.dao.StudentDao;
import com.h_jdbc3.model.Student;

/**
 * 
 * @author xiaocan
 * 2017年6月6日
 */
public class StudentDaoImpl implements StudentDao {
	
private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public int addStudent(Student student) {
		String sql = "insert into t_student values(null, :name, :age)";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("name", student.getName());
		sps.addValue("age", student.getAge());
		return namedParameterJdbcTemplate.update(sql,sps);
	}

	public int updateStudent(Student student) {
		String sql = "update t_student set name=:name, age=:age where id= :id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("name", student.getName());
		sps.addValue("age", student.getAge());
		sps.addValue("id", student.getId());
		return namedParameterJdbcTemplate.update(sql,sps);
	}

	public int deleteStudent(int id) {
		String sql = "delete from t_student where id=:id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("id", id);
		return namedParameterJdbcTemplate.update(sql,sps);
	}

	public List<Student> findStudents() {
		String sql="select * from t_student";
		final List<Student> studentList = new ArrayList<Student>();
		namedParameterJdbcTemplate.query(sql, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				studentList.add(student);
			}
		});
		return studentList;
	}

}

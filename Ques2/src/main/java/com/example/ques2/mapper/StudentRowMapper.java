package com.example.ques2.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.ques2.model.Student;



public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentid(rs.getInt("studentid"));
		student.setFirstname(rs.getString("firstname"));
		student.setLastname(rs.getString("lastname"));
		student.setTotalmarks(rs.getInt("totalmarks"));
		return student;
	}

}
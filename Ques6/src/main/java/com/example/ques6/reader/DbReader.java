package com.example.ques6.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;


import com.example.ques6.model.Student;

public class DbReader extends JdbcCursorItemReader<Student>{
	public DbReader(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql("select * from student");
		this.setRowMapper(new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				
				student.setStudentid(rs.getInt("studentid"));
				student.setFirstname(rs.getString("firstname"));
				student.setLastname(rs.getString("lastname"));
				student.setTotalmarks(rs.getInt("totalmarks"));
				
				return student;
			}
			
		}) ;
	}

}

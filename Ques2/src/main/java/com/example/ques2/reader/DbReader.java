package com.example.ques2.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;

import com.example.ques2.mapper.StudentRowMapper;
import com.example.ques2.model.Student;

public class DbReader extends JdbcCursorItemReader<Student>{
	public DbReader(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql("SELECT * FROM student");
		this.setRowMapper(new StudentRowMapper());
		
	}
	}



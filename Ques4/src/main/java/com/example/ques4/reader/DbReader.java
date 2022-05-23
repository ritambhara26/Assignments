package com.example.ques4.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.RowMapper;

import com.example.ques4.model.Employee;

public class DbReader extends JdbcCursorItemReader<Employee>{
	public DbReader(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql("select * from employee;");
		this.setRowMapper(new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setSalary(rs.getInt("salary"));
				return e;
			}
			
		}) ;
	}

}

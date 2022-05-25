package com.example.ques3.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.example.ques3.model.Person;

public class DbWriter extends JdbcBatchItemWriter<Person> {
	public DbWriter (DataSource dataSource) {
		System.out.println("writer started");
		this.setDataSource(dataSource);
		this.setSql("INSERT INTO person(id,name,age) VALUES(?,?,?)");
		this.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<Person>()  {

			@Override
			public void setValues(Person item, PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, item.getId());
				ps.setString(2, item.getName());
				ps.setInt(3, item.getAge());
				
			}
			
		});
		System.out.println("writer completed");
	}
	
	
	
}

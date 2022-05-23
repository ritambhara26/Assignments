package com.example.ques1.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.example.ques1.model.Employee;

public class DbWriter extends JdbcBatchItemWriter<Employee>{
	public DbWriter(DataSource dataSource) {
	this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
	this.setSql("insert into emp(id,name, email,salary) values(?,?,?,?)");
	this.setDataSource(dataSource);
	this.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<Employee>() {

		@Override
		public void setValues(Employee item, PreparedStatement ps) throws SQLException {
			// TODO Auto-generated method stub
			ps.setInt(1, item.getId());
			ps.setString(2, item.getName());
			ps.setString(3, item.getEmail());
			ps.setInt(4, item.getSalary());
		}});
	

}
}
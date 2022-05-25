package com.example.ques5.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;


import com.example.ques5.model.User;

public class DbWriter extends JdbcBatchItemWriter<User>{
	public DbWriter(DataSource dataSource) {
	this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
	this.setSql("insert into us(id, name, age) values(?,?,?)");
	this.setDataSource(dataSource);
	this.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<User>() {

		@Override
		public void setValues(User item, PreparedStatement ps) throws SQLException {
			// TODO Auto-generated method stub
		ps.setInt(1, item.getId());
		ps.setString(2, item.getName());
		ps.setInt(3, item.getAge());
			
		}});	


	}}
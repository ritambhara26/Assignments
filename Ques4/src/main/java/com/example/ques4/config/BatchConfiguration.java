package com.example.ques4.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.example.ques4.model.Employee;
import com.example.ques4.processor.EmployeeProcessor;
import com.example.ques4.reader.DbReader;
import com.example.ques4.writer.XmlWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public DbReader reader() {
		return new DbReader(dataSource);
	}
	@Bean
	public EmployeeProcessor processor() {
		return new EmployeeProcessor();
	}
	@Bean
	 public XmlWriter writer() {
		 return new XmlWriter();
	 }
	
	
	

	
	@Bean
	public Step executeEmployeeStep() {
		
		return stepBuilderFactory.get("executeEmployeeStep")
				.<Employee, Employee>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
		
		
	}
	
	@Bean
	public Job processEmployeeJob() {
		return jobBuilderFactory.get("processEmployeeJob")
				.incrementer(new RunIdIncrementer())
				.flow(executeEmployeeStep())
				.end()
				.build();
	}
	}

 
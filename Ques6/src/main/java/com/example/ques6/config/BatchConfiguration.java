package com.example.ques6.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ques6.model.Student;
import com.example.ques6.processor.StudentProcessor;
import com.example.ques6.reader.DbReader;
import com.example.ques6.writer.TxtWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public DataSource dataSource;
	
	@Bean
	public DbReader reader() {
		return new DbReader(dataSource);
	}
	@Bean
	public StudentProcessor processor() {
		return new StudentProcessor();
	}
	@Bean
	 public TxtWriter writer() {
		 return new TxtWriter();
	 }
	@Bean
	public Step executeEmployeeStep() {
		
		return stepBuilderFactory.get("executeEmployeeStep")
				.<Student, Student>chunk(3)
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

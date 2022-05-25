package com.example.ques5.config;

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


import com.example.ques5.model.User;
import com.example.ques5.processor.UserItemProcessor;
import com.example.ques5.reader.TxtReader;
import com.example.ques5.writer.DbWriter;

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
	public TxtReader reader() {
		return new TxtReader();
	}
	@Bean
	public UserItemProcessor processor() {
		return new UserItemProcessor();
		
	}
	@Bean
	 public DbWriter writer() {
		 return new DbWriter(dataSource);
	 }
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<User, User>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
		
	}
	
	@Bean
	public Job importPersonJob() {
		return jobBuilderFactory.get("importPersonJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}
}

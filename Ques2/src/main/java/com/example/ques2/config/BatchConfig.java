package com.example.ques2.config;

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

import com.example.ques2.model.Student;
import com.example.ques2.processor.StudentItenProcessor;
import com.example.ques2.reader.DbReader;

import com.example.ques2.writer.CsvWriter;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	
	@Bean
	public DbReader reader() {
		return new DbReader(dataSource);
	}
	@Bean
	public StudentItenProcessor processor(){
		return new StudentItenProcessor();
	}
	
	@Bean
	public CsvWriter writer() {
		return new CsvWriter();
	}
	
	
	
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1")
				.<Student,Student>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public Job exportPerosnJob(){
		return jobBuilderFactory.get("exportPeronJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}
}
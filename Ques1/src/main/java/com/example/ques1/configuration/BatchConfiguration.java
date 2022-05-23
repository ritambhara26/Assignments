package com.example.ques1.configuration;

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



import com.example.ques1.model.Employee;
import com.example.ques1.processor.EmployeeItemProcessor;
import com.example.ques1.reader.CsvReader;
import com.example.ques1.writer.DbWriter;



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
	public CsvReader reader() {
		return new CsvReader();
	}
	@Bean
	public EmployeeItemProcessor processor() {
		return new EmployeeItemProcessor();
		
	}
	@Bean
	 public DbWriter writer() {
		 return new DbWriter(dataSource);
	 }
	
	
	 @Bean
	    public Job importUserJob() {
	        return jobBuilderFactory.get("importUserJob")
	                .incrementer(new RunIdIncrementer())
	                .flow(step1())
	                .end()
	                .build();
	    }
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Employee, Employee> chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
}

package com.example.ques3.config;


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

import com.example.ques3.config.processor.PersonItemProcessor;
import com.example.ques3.model.Person;
import com.example.ques3.reader.XmlReader;
import com.example.ques3.writer.DbWriter;

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
	public XmlReader reader() {
		return new XmlReader();
	}
	
	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}
	
	@Bean
	public DbWriter writer() {
		return new DbWriter(dataSource);
	}
	
			
	@Bean
	public Job importPersonJob() {
		return jobBuilderFactory.get("importPersonJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}
			
		
		
		@Bean
		public Step step1() {
			return stepBuilderFactory.get("step1")
					.<Person, Person>chunk(3)
					.reader(reader())
					.processor(processor())
					.writer(writer())
					.build();
			
		}
		
		
	}



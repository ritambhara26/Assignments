package com.example.ques1.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

import org.springframework.core.io.ClassPathResource;

import com.example.ques1.model.Employee;

public class CsvReader extends FlatFileItemReader<Employee> {
	private static final Logger logger = LoggerFactory.getLogger(CsvReader.class);
	public CsvReader() {
		logger.info("Data is read from the CSV file");
		
		this.setResource(new ClassPathResource("emp.csv"));
		LineMapper<Employee> lm=linemapper();
        this.setLineMapper(lm);
       
	}
	
	
	public LineMapper<Employee> linemapper(){
		DefaultLineMapper<Employee> linemap=new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer= new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames(new String[] {"id","name","email","salary"});
		linemap.setLineTokenizer(lineTokenizer);
		BeanWrapperFieldSetMapper<Employee>  beanwrap=new BeanWrapperFieldSetMapper<>();
		beanwrap.setTargetType(Employee.class);
		linemap.setFieldSetMapper(beanwrap);
		return linemap;
		
	}
	

}

package com.example.ques2.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

import com.example.ques2.model.Student;

public class CsvWriter extends FlatFileItemWriter<Student>{
	public CsvWriter(){
		this.setResource(new ClassPathResource("student.csv"));
		
		DelimitedLineAggregator<Student> lineAggregator = new DelimitedLineAggregator<Student>();
		lineAggregator.setDelimiter(",");
		
		BeanWrapperFieldExtractor<Student>  fieldExtractor = new BeanWrapperFieldExtractor<Student>();
		fieldExtractor.setNames(new String[]{"studentid","firstname","lastname","totalmarks"});
		lineAggregator.setFieldExtractor(fieldExtractor);
		
		this.setLineAggregator(lineAggregator);
		
	}

}

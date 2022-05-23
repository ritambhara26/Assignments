package com.example.ques6.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

import com.example.ques6.model.Student;

public class TxtWriter extends FlatFileItemWriter<Student> {
	public TxtWriter() {
		this.setResource(new ClassPathResource("student.txt"));
		
		DelimitedLineAggregator<Student> lineAggregator = new DelimitedLineAggregator<Student>();
		lineAggregator.setDelimiter(",");
		
		BeanWrapperFieldExtractor<Student> fieldExtracter = new BeanWrapperFieldExtractor<Student>();
		fieldExtracter.setNames(new String[] {"studentid","firstname","lastname","totalmarks"});
		
		lineAggregator.setFieldExtractor(fieldExtracter);
		this.setLineAggregator(lineAggregator);
	}

}

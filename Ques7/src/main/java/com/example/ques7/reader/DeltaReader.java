package com.example.ques7.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.example.ques7.model.Student;

public class DeltaReader extends FlatFileItemReader<Student>{
public DeltaReader() {
	this.setResource(new FileSystemResource("src/main/resources/output/delta.csv"));
	 DefaultLineMapper<Student> mapper=new DefaultLineMapper<>();
	 DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
	 tokenizer.setDelimiter(",");
	 tokenizer.setNames(Student.getFields());
	 mapper.setLineTokenizer(tokenizer);
	 BeanWrapperFieldSetMapper<Student> fieldmapper=new BeanWrapperFieldSetMapper<>();
	 fieldmapper.setTargetType(Student.class);
	 mapper.setFieldSetMapper(fieldmapper);
	this.setLineMapper(mapper);
	this.setLinesToSkip(1);
	
}
}

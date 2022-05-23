package com.example.ques7.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.example.ques7.model.Student;

public class PreviousReader extends FlatFileItemReader<Student>{

	public PreviousReader() {
		this.setResource(new FileSystemResource("src/main/resources/input/student2.csv"));
   	 DefaultLineMapper<Student> mapper=new DefaultLineMapper<>();
   	 DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
   	 tokenizer.setDelimiter(",");
   	 tokenizer.setNames(Student.getFields());
   	 mapper.setLineTokenizer(tokenizer);
   	 BeanWrapperFieldSetMapper<Student> fieldmapper=new BeanWrapperFieldSetMapper<>();
   	 fieldmapper.setTargetType(Student.class);
   	 mapper.setFieldSetMapper(fieldmapper);
   	this.setLineMapper(mapper);
   
   	 
    }
	}

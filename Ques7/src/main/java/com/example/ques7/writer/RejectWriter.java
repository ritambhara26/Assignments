package com.example.ques7.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.example.ques7.model.Student;

public class RejectWriter extends FlatFileItemWriter<Student>{
	public RejectWriter() {
		this.setResource(new FileSystemResource("src/main/resources/output/rejected.csv"));
    	DelimitedLineAggregator<Student> aggregator=new DelimitedLineAggregator<>();
    	aggregator.setDelimiter(",");
    
    	BeanWrapperFieldExtractor<Student> extractor=new BeanWrapperFieldExtractor<>();
    	extractor.setNames(Student.getFields());
		aggregator.setFieldExtractor(extractor);
		this.setHeaderCallback(new FlatFileHeaderCallback() {

			@Override
			public void writeHeader(Writer writer) throws IOException {
				writer.write("student_Id,name,email,marks");
				
			}
			
		});
		this.setLineAggregator(aggregator);
		
		
     
	}

}

package com.example.ques6.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.ques6.model.Student;



public class StudentProcessor implements ItemProcessor<Student, Student> {
	private static final Logger log = LoggerFactory.getLogger(StudentProcessor.class);
	@Override
	public Student process(Student item) throws Exception {
		// TODO Auto-generated method stub
		if(item.getTotalmarks()>80) {
			return item;
			
			
		}
		log.info("Students are ( " + item + ")");
		return null;
		

}}


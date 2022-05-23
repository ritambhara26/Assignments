package com.example.ques2.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.ques2.model.Student;



public class StudentItenProcessor implements ItemProcessor<Student, Student>{
	private static final Logger log = LoggerFactory.getLogger(StudentItenProcessor.class);

	@Override
	public Student process(Student student) throws Exception {
		if(student.getTotalmarks()>80) {
			return student;
		}
		log.info("Students are ( " + student + ")");
		return null;
	}
}
package com.example.ques7.processor;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.ques7.model.Student;
import com.example.ques7.writer.PreviousWriter;


@Component
public class StudentItemProcessor implements ItemProcessor< Student,Student> {

	@Override
	public Student process(Student item) throws Exception {
		Map<Integer,Student> previousmap=PreviousWriter.Previous_Map;
		
		if(previousmap.containsKey(item.getStudent_Id())) {
			
			return null;
		}
		else {
			
			
			return item;
		}
	}
   

}
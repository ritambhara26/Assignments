package com.example.ques7.writer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;

import com.example.ques7.model.Student;


public class PreviousWriter implements ItemWriter<Student> {
     public static Map<Integer,Student> Previous_Map=new HashMap<>();
	@Override
	public void write(List<? extends Student> items) throws Exception {
	   for(Student student:items) {
		   Previous_Map.put(student.getStudent_Id(),student);
		  
	   }
	
	}

}
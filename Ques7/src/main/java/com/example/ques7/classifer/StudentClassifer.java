package com.example.ques7.classifer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.classify.Classifier;

import com.example.ques7.model.Student;

public class StudentClassifer  implements Classifier<Student,ItemWriter<? super Student>>{
	
	private static final long serialVersionUID = 1L;
	private ItemWriter<Student> SuccessitemWriter;
	private ItemWriter<Student> RejectitemWriter;
	public StudentClassifer(ItemWriter<Student> successitemwriter,ItemWriter<Student> rejectitemwriter) {
		this.SuccessitemWriter=successitemwriter;
		this.RejectitemWriter=rejectitemwriter;
		
	}

	@Override
	public ItemWriter<Student> classify(Student classifiable) {
		
		return classifiable.getMarks()>50?SuccessitemWriter:RejectitemWriter;
	}

}
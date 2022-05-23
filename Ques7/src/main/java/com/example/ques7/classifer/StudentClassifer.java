package com.example.ques7.classifer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.classify.Classifier;

import com.example.ques7.model.Student;

public class StudentClassifer  implements Classifier<Student,ItemWriter<? super Student>>{
	
	private static final long serialVersionUID = 1L;
	private ItemWriter<Student> Success_ItemWriter;
	private ItemWriter<Student> Reject_ItemWriter;
	public StudentClassifer(ItemWriter<Student> success_itemwriter,ItemWriter<Student> reject_itemwriter) {
		this.Success_ItemWriter=success_itemwriter;
		this.Reject_ItemWriter=reject_itemwriter;
		
	}

	@Override
	public ItemWriter<Student> classify(Student classifiable) {
		
		return classifiable.getMarks()>50?Success_ItemWriter:Reject_ItemWriter;
	}

}
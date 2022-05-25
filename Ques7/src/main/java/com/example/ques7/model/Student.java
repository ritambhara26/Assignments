package com.example.ques7.model;

public class Student {
	   private int student_Id;
	   private String name;
	   private String email;
	   private int marks;
	   public static String[] getFields() {
		   return new String[] {"student_Id","name","email","marks"};
	   }
	   
	public int getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	   public Student(int student_Id, String name, String email, int marks) {
		super();
		this.student_Id = student_Id;
		this.name = name;
		this.email = email;
		this.marks = marks;
	}

	public Student() {
		   
	   }
	}


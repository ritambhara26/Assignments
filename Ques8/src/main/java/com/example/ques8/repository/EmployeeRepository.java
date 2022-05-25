package com.example.ques8.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ques8.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	

	
	
}

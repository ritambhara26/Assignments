package com.example.ques1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ques1.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}

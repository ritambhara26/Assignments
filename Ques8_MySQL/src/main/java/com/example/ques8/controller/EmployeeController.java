package com.example.ques8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ques8.model.Employee;
import com.example.ques8.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeerepository;
	
	@GetMapping(path ="getdata", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})		
	public List<Employee> getEmp(){
		
		return employeerepository.findAll();
		
	}
	
	 @PostMapping("/postdata")
		public void addEmployee(@RequestBody Employee emp) {
		 employeerepository.save(emp);
			
		}
	@DeleteMapping("/deletedata/{id}")
		public int deleteEmployee(@PathVariable int id) {
		employeerepository.deleteById(id);
			return id;
		}
	
}

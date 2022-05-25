package com.example.ques8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ques8.controller.EmployeeController;
import com.example.ques8.model.Employee;
import com.example.ques8.repository.EmployeeRepository;

@SpringBootTest
class Ques8MySqlApplicationTests {
	/*
	 @Test void contextLoads() { }
	 */

	@Autowired
	EmployeeController employeecontroller;
	
	@Mock
	EmployeeRepository employeerepository;
	
	
	
	@Test
	public void getUsersTest() {
	when(employeerepository.findAll())
	.thenReturn(Stream.of(new Employee(1,"Emma","emma@gmail.com",25000))
	.collect(Collectors.toList()));
	assertEquals(3, employeecontroller.getEmp().size());
	}
	
	
}

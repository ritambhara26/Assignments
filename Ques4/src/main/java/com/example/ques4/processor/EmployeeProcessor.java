package com.example.ques4.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


import com.example.ques4.model.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {
	private static final Logger log = LoggerFactory.getLogger(EmployeeProcessor.class);
	@Override
	public Employee process(Employee item) throws Exception {
		// TODO Auto-generated method stub
		if(item.getSalary()>30000) {
			return item;
			
			
		}
		log.info("Employees are ( " + item + ")");
		return null;
		

}}

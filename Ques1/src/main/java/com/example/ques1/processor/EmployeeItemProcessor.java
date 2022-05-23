package com.example.ques1.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.example.ques1.model.Employee;



public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee>{

	
private static final Logger log = LoggerFactory.getLogger(EmployeeItemProcessor.class);
	
	@Override
	public Employee process(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		if(employee.getSalary()>30000) {
			return employee;
			
			
		}
		log.info("Employees are ( " + employee + ")");
		return null;
		
	}

}

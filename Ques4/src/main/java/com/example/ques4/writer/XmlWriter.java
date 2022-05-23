package com.example.ques4.writer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.ClassPathResource;

import org.springframework.oxm.xstream.XStreamMarshaller;

import com.example.ques4.model.Employee;

public class XmlWriter extends StaxEventItemWriter<Employee>{
	public XmlWriter() {
		this.setResource (new ClassPathResource("emp.xml"));
		
		Map<String, String> aliasMap = new HashMap<String, String>();
		aliasMap.put("Employee", "com.example.ques4.model.Employee");
		
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(aliasMap);
		
		this.setMarshaller(marshaller);
		this.setRootTagName("employees");
		this.setOverwriteOutput(true);	
	}

}

package com.example.ques3.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.example.ques3.model.Person;

public class XmlReader extends StaxEventItemReader<Person> {
	public XmlReader() {
		this.setResource(new ClassPathResource("person.xml"));
		this.setFragmentRootElementName("Person");
		
		Map<String, String> aliases = new HashMap<String, String>();
		aliases.put("Person", "com.example.ques3.model.Person");
	
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(aliases);
		
		this.setUnmarshaller(marshaller);
	}

}

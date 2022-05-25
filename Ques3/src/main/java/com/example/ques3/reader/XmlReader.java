package com.example.ques3.reader;



import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.ques3.model.Person;



	public class XmlReader extends StaxEventItemReader<Person> {
		public XmlReader() {
			System.out.println("reader stared");
			this.setResource(new ClassPathResource("person.xml"));
			this.setFragmentRootElementName("person");
			Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
	    	marshaller.setClassesToBeBound(com.example.ques3.model.Person.class);
	    	this.setUnmarshaller(marshaller);
	    	System.out.println("reader completed");
		}

	}
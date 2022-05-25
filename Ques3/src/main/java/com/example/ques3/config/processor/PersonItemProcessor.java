/**
 * 
 */
package com.example.ques3.config.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.ques3.model.Person;

/**
 * @author RITAMBHARA
 *
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	@Override
	public Person process(Person item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("processor started");
		if(item.getAge()>30) {
			return item;
		}
		log.info("People are ( " + item + ")");
		return null;
	}

	

}

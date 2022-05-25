package com.example.ques5.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


import com.example.ques5.model.User;

public class UserItemProcessor implements ItemProcessor<User, User>{
	private static final Logger log = LoggerFactory.getLogger(UserItemProcessor.class);

	@Override
	public User process(User item) throws Exception {
		System.out.println("Processor started");
		// TODO Auto-generated method stub
		if(item.getAge()>35) {
			return item;
		}
		log.info("Users are ( " + item + ")");
		return null;
		
	}
	

}

package com.spring.app.message;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer>{
	
	public Message findByName(String name);
	
	public List<Message> findByUserProfileId(int id);
	
}

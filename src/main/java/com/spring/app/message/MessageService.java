package com.spring.app.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;
	
	
	public List<Message>getAllMessages(int userId) {
		List<Message> messages=new ArrayList<Message>();
		/*
		 * List<Message> messages= Arrays.asList(
				new Message(2001, "softy", "IT expert", 101),
				new Message(2002, "dev ops", "CICD expert", 101));
		 */
		messageRepo.findByUserProfileId(userId)
				.forEach(messages::add);
		return messages;
	}
	
	public Message getMessage(int id) {
		return messageRepo.findOne(id);
	}
	
	public void addMessage(Message msg) {
		messageRepo.save(msg);
	}
	public void updateMessage(int msgId, Message updatedMsg) throws Throwable {
		Message existedMessage=messageRepo.findOne(msgId);
		if(existedMessage!=null) {
			messageRepo.save(updatedMsg);
		}else {
			throw new Throwable("Message belong to the given id doesn't exist"+msgId);
		}
	}
	
	public void deleteMessage(int id) {
		messageRepo.delete(id);
	}
}

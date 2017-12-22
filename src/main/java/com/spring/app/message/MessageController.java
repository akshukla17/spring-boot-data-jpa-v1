package com.spring.app.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.user.UserProfile;

@RestController
public class MessageController {

	@Autowired
	private MessageService msgService;

	@RequestMapping(value = "/users/{userId}/messages")
	public List<Message> getAllMessages(@PathVariable int userId) {
		return msgService.getAllMessages(userId);
	}

	@RequestMapping(value = "/users/{userId}/messages/{id}")
	public Message getMessage(@PathVariable int id) {
		return msgService.getMessage(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/{userId}/messages")
	public void addMessage(@RequestBody Message msg,@PathVariable int userId) {
		msg.setUserProfile(new UserProfile(userId, "", 0));
		msgService.addMessage(msg);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/messages/{id}")
	public void updateMessage(@RequestBody Message msg, @PathVariable int id,@PathVariable int userId) throws Throwable {
		msg.setUserProfile(new UserProfile(userId, "", 0));
		msgService.updateMessage(id, msg);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}/messages/{id}")
	public void deleteMessage(@PathVariable int id) {
		msgService.deleteMessage(id);
	}
}

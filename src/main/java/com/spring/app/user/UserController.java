package com.spring.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/users")
	public List<UserProfile> getAllUsers() {
		return userService.getUsers();
	}

	@RequestMapping(value = "/users/{id}")
	public UserProfile getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody UserProfile u) {
		userService.addUser(u);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody UserProfile user, @PathVariable int id) throws Exception {
		userService.updateUser(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}

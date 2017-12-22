package com.spring.app.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	/*List<User> users= new ArrayList<>( Arrays.asList(
			new User(101,"Ajay",30),
			new User(102,"Vijay",29),
			new User(104,"Ram",45)));
*/
	public List<UserProfile>getUsers() {
		//return users;
		List<UserProfile> users=new ArrayList<UserProfile>();
		userRepo.findAll()
				.forEach(users::add);
		return users;
	}
	
	public UserProfile getUser(int id) {
		//return users.stream().filter(u ->(u.getId()==id)).findFirst().get();
		return userRepo.findOne(id);
	}
	
	public void addUser(UserProfile user) {
		//users.add(user);
		userRepo.save(user);
	}
	public void updateUser(int id, UserProfile updateUser) throws Exception {
	/*	User user=users.stream().filter(u -> (u.getId()==updateUser.getId())).findFirst().get();
		user.setAge(updateUser.getAge());
		user.setName(updateUser.getName());
	*/
		UserProfile existedUser=userRepo.findOne(id);
		if(existedUser!=null) {
			existedUser.setAge(updateUser.getAge());
			existedUser.setName(updateUser.getName());
		}else {
			throw new Exception("User doesn't exist for this id : "+id);
		}
	}
	
	public void deleteUser(int id) {
		//users.remove(getUser(id));
		userRepo.delete(id);
	}
}

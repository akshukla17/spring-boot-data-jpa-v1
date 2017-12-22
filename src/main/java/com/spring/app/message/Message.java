package com.spring.app.message;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.spring.app.user.UserProfile;

@Entity
public class Message {
	
	@Id
	private int id;
	private String name;
	private String description;
	
	@ManyToOne
	private UserProfile userProfile;

	public Message() {
	}

	public Message(int id, String name, String desc,int userId) {
		super();
		this.id = id;
		this.name = name;
		this.description=desc;
		this.userProfile=new UserProfile(userId,"",0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}

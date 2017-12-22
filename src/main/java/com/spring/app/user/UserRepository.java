package com.spring.app.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProfile, Integer>{
	
}

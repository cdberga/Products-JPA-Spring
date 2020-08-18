package com.berga.jpaspring.service;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.berga.jpaspring.model.User;
import com.berga.jpaspring.repository.UserRepository;

public class UserService implements GenericService<User, String> {

	private final UserRepository userRepository;
	
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public String getId(User entity) {
		return entity.getUserId();
	}

	@Override
	public CrudRepository<User, String> getRepository() {
		return this.userRepository;
	}
	
	@Override
	public User save(User entity) {
		entity.setUserId(UUID.randomUUID().toString());
		return GenericService.super.save(entity);
	}

}

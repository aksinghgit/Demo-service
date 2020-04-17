package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

/**
 * @author amritesh
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	public User getUserById(String userId) {
		
		Optional<User> optionalUser = userRepository.findById(userId);
		
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		
		return null;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public boolean deleteUser(String userId) {
		try {
		userRepository.deleteById(userId);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}
}
package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Post;
import com.demo.entity.User;
import com.demo.service.PostService;
import com.demo.service.UserService;

/**
 * @author amritesh
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping("/service/user")
	public ResponseEntity<User> saveEmployee(@RequestBody User user) {
		User savedUser = userService.createUser(user);
		System.out.println("User Saved Successfully" + savedUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	@GetMapping("/service/users")
	public List<User> getUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}

	@GetMapping("/service/user/{userId}")
	public User getEmployee(@PathVariable(name = "userId") String userId) {
		return userService.getUserById(userId);
	}

	@DeleteMapping("/service/user/{userId}")
	public boolean deleteEmployee(@PathVariable(name = "userId") String userId) {
		return userService.deleteUser(userId);		
	}

	@PutMapping("/service/user/{userId}")
	public User updateEmployee(@RequestBody User user, @PathVariable(name = "userId") String userId) {
		User savedUser = userService.getUserById(userId);
		if (savedUser != null) {
			user.setId(savedUser.getId());
			savedUser = userService.updateUser(user);
		}
		return savedUser;
	}

}
package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.demo.entity.User;
import com.demo.model.AuthResponse;
import com.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author amritesh
 *
 */
@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/service/user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
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
	public User getUser(@PathVariable(name = "userId") String userId) {
		return userService.getUserById(userId);
	}

	@DeleteMapping("/service/user/{userId}")
	public boolean deleteUser(@PathVariable(name = "userId") String userId) {
		return userService.deleteUser(userId);
	}

	@PutMapping("/service/user/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable(name = "userId") String userId) {
		return userService.updateUser(user, userId);
	}

	@PostMapping("/service/user/authenticate")
	public ResponseEntity<AuthResponse> authenticateUser(@RequestBody User user) {
		log.info(String.format("%s.%s : Input request : %s", getClass(), "authenticateUser", user));
		boolean isValid = userService.authenticateUser(user);
		
		if (isValid) {
			return ResponseEntity.status(HttpStatus.OK).body(AuthResponse.builder().status(true).build());
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(AuthResponse.builder().status(false).errorMessage("UserId or Passwrod is not valid").build());
		}

	}
	
	@PostMapping("/service/user/updatePassword")
	public ResponseEntity<AuthResponse> updatePassword(@RequestBody User user) {
		log.info(String.format("%s.%s : Input request : %s", getClass(), "updatePassword", user));
		boolean isValid = userService.authenticateUser(user);
		
		if (isValid) {
			return ResponseEntity.status(HttpStatus.OK).body(AuthResponse.builder().status(true).build());
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body(AuthResponse.builder().status(false).errorMessage("UserId or Passwrod is not valid").build());
		}

	}

}
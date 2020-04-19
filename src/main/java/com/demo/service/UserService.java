package com.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.exception.GenericException;
import com.demo.repository.UserRepository;
import com.demo.util.PasswordUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author amritesh
 *
 */
@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User getUserById(String userId) {

		Optional<User> optionalUser = userRepository.findById(userId);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}

		return null;
	}

	public User createUser(User user) {
		String secureSalt = PasswordUtils.getSalt(30);
		String securePwd = PasswordUtils.generateSecurePassword(user.getPassword(), secureSalt);
		user.setSecureSalt(secureSalt);
		user.setPassword(securePwd);
		user.setOldPassword(securePwd);

		return userRepository.save(user);
	}

	public boolean deleteUser(String userId) {
		try {
			userRepository.deleteById(userId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public User updateUser(User user, String userId) {

		User userVo = getUserById(userId);

		if (Objects.isNull(userVo)) {
			throw new GenericException("User not found - " + userId);
		}

		if (Objects.isNull(user.getFname())) {
			user.setFname(userVo.getFname());
		}
		if (Objects.isNull(user.getLname())) {
			user.setLname(userVo.getLname());
		}
		if (Objects.isNull(user.getUsername())) {
			user.setUsername(userVo.getUsername());
		}
		if (Objects.isNull(user.getSchoolId())) {
			user.setSchoolId(userVo.getSchoolId());
		}

		String secureSalt = userVo.getSecureSalt();
		if (Objects.nonNull(user.getPassword())) {
			String securePwd = PasswordUtils.generateSecurePassword(user.getPassword(), secureSalt);
			user.setPassword(securePwd);
			user.setOldPassword(securePwd);

		} else {
			user.setPassword(userVo.getPassword());
			user.setOldPassword(userVo.getOldPassword());
		}
		user.setSecureSalt(secureSalt);
		user.setCreate_ts(userVo.getCreate_ts());
		
		log.debug(String.format("%s.%s : User profile updated for userId - %s,  %s", getClass(), "updateUser", userId,
				user));

		return userRepository.save(user);
	}

	/**
	 * @param user
	 * @return
	 */
	public boolean authenticateUser(User user) {
		boolean isValid = false;

		if (Objects.nonNull(user.getUsername()) && Objects.nonNull(user.getPassword())) {
			User userV = userRepository.findUserByUsername(user.getUsername());

			if (Objects.nonNull(userV) && Objects.nonNull(userV.getPassword())
					&& Objects.nonNull(userV.getSecureSalt())) {

				String generatedPwd = PasswordUtils.generateSecurePassword(user.getPassword(), userV.getSecureSalt());
				if (generatedPwd.equals(userV.getPassword())) {
					isValid = true;
				}
			}

			log.debug(String.format("%s.%s : User exist in db : %s", getClass(), "authenticateUser", user));

		}
		log.info(String.format("%s.%s : User authenticated : %s", getClass(), "authenticateUser", isValid));

		return isValid;
	}

}
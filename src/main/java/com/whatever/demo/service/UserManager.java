package com.whatever.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatever.demo.domain.entity.User;
import com.whatever.demo.domain.repository.UserRepository;

@Service
public class UserManager {
	final UserRepository userRepo;
	
	@Autowired
	public UserManager(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User login(String username, String password) {
		List<User> userList = this.userRepo.findByUsername(username);
		if (userList.size() == 0 || userList.get(0).getPassword() != password) {
			return null;
		} else {
			return userList.get(0);
		}
	}
	
	public User getCurrentUser() {
		List<User> userList = (List<User>) this.userRepo.findAll();
		if (userList.size() == 0) {
			return null;
		} else {
			return userList.get(0);
		}
	}
	
	public User register(User rawUser) {
		return this.userRepo.save(rawUser);
	}
	
	public User getUserInfo(Long userId) {
		return this.userRepo.findOne(userId);
	}
}

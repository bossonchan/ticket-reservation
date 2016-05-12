package com.whatever.demo.web;

import org.springframework.web.bind.annotation.*;

import com.whatever.demo.Application;
import com.whatever.demo.domain.entity.User;
import com.whatever.demo.service.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	final UserManager userManager;
	
	static String SESSION_ATTR_USER = "session_attr_user";
	
	@Autowired
	public UserController(UserManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping(value = "/session", method = RequestMethod.POST)
	User login(@RequestBody User userToLogIn, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		User currentUser = (User) session.getAttribute(SESSION_ATTR_USER);
		if (currentUser != null) {
			throw new ConflictException("You have been logged in.");
		} else {
			User userLoggedIn = this.userManager.login(userToLogIn.getUsername(), userToLogIn.getPassword());
			if (userLoggedIn == null) {
				throw new BadRequestException("Login failed, username or password is wrong.");
			} else {
				// update session
				session.setAttribute(SESSION_ATTR_USER, userLoggedIn);
				return userLoggedIn;
			}	
		}
		
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	User getCurrentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();

		User currentUser = (User) session.getAttribute(SESSION_ATTR_USER);
		if (currentUser == null) {
			throw new UnauthorizedException("You should logged in first.");
		}
		return this.userManager.getUserInfo(currentUser.getId());
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.DELETE)
	User logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute(SESSION_ATTR_USER) == null) {
			throw new ConflictException("You have been logged out.");
		} else {
			User userLoggedOut = (User) session.getAttribute(SESSION_ATTR_USER);
			session.removeAttribute(SESSION_ATTR_USER);
			return userLoggedOut;
		}
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	User register(@RequestBody User rawUser) {
		return this.userManager.register(rawUser);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	User getUserInfo(@PathVariable Long userId) {
		User foundUser = this.userManager.getUserInfo(userId);
		if (foundUser == null) {
			throw new NotFoundException("Could not find the user detail.");
		} else {
			return foundUser;
		}
	}
}

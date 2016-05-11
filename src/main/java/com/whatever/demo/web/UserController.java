package com.whatever.demo.web;

import org.springframework.web.bind.annotation.*;

import com.whatever.demo.domain.User;
import com.whatever.demo.service.UserManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;

import org.springframework.session.Session;
import org.springframework.session.SessionRepository;

@RestController
public class UserController<S extends Session> {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	final UserManager userManager;
	private SessionRepository<S> sessionRepo;
	
	static String SESSION_ATTR_USER = "session_attr_user";

	@Autowired
	public UserController(UserManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping(value = "/session", method = RequestMethod.POST)
	User login(@RequestBody User userToLogIn, @CookieValue("SESSIONID") String sessionId, HttpServletResponse response) {
		// create session if not found
		S session = sessionRepo.getSession(sessionId);
		if (session == null) {
			session = sessionRepo.createSession();
		}
		
		User currentUser = session.getAttribute(SESSION_ATTR_USER);
		if (currentUser != null) {
			throw new LoginConflictException();
		} else {
			User userLoggedIn = this.userManager.login(userToLogIn.getUsername(), userToLogIn.getPassword());
			if (userLoggedIn == null) {
				throw new LoginFailedException();
			} else {
				// update session
				session.setAttribute(SESSION_ATTR_USER, userLoggedIn);
				sessionRepo.save(session);
				
				// update cookie anyway.
				response.addCookie(new Cookie("SESSIONID", session.getId()));
				
				return userLoggedIn;
			}	
		}
		
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	User getCurrentUser(@CookieValue("SESSIONID") String sessionId) {
		S session = sessionRepo.getSession(sessionId);
		if (session == null) {
			throw new UserNotFoundException();
		} else {
			User currentUser = session.getAttribute(SESSION_ATTR_USER);
			if (currentUser == null) {
				throw new UserNotFoundException();
			}
			return this.userManager.getUserInfo(currentUser.getId());
		}
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.DELETE)
	void logout(@CookieValue("SESSIONID") String sessionId) {
		S session = sessionRepo.getSession(sessionId);
		if (session == null) {
			throw new LogoutConflictException();
		} else {
			session.removeAttribute(SESSION_ATTR_USER);
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
			throw new UserNotFoundException();
		} else {
			return foundUser;
		}
	}
}


@ResponseStatus(HttpStatus.CONFLICT)
class LoginConflictException extends RuntimeException {
	public LoginConflictException() {
		super("Login conflict: You have been logged in.");
	}
}

@ResponseStatus(HttpStatus.CONFLICT)
class LogoutConflictException extends RuntimeException {
	public LogoutConflictException() {
		super("Logout conflict: You have been logged out.");
	}
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class LoginFailedException extends RuntimeException {
	public LoginFailedException() {
		super("Login failed: username or password is wrong.");
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("could not find user.");
	}
}
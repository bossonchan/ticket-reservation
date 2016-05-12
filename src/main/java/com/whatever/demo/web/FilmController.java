package com.whatever.demo.web;

import org.springframework.web.bind.annotation.*;

import com.whatever.demo.Application;
import com.whatever.demo.domain.entity.Cinema;
import com.whatever.demo.domain.entity.Film;
import com.whatever.demo.domain.entity.FilmDescription;
import com.whatever.demo.domain.entity.Room;
import com.whatever.demo.domain.entity.RoomSeat;
import com.whatever.demo.domain.entity.User;
import com.whatever.demo.service.FilmManager;
import com.whatever.demo.service.UserManager;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
public class FilmController{
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	final UserManager userManager;
	final FilmManager filmManager;
	
	static String SESSION_ATTR_USER = "session_attr_user";
	
	@Autowired
	public FilmController(UserManager userManager, FilmManager filmManager) {
		this.userManager = userManager;
		this.filmManager = filmManager;
	}

	@RequestMapping(value = "/films", method=RequestMethod.GET)
	public List<FilmDescription> retreiveFilmsAccordingToCityCode(@RequestParam("city") Long cityCode) {
		return this.filmManager.findByCityCode(cityCode);
	}
	
	@RequestMapping(value = "/films/{filmId}", method = RequestMethod.GET)
	public FilmDescription getFilmDetial(@PathVariable Long filmId) {
		FilmDescription foundFilm =  this.filmManager.getFilmDetail(filmId);
		if (foundFilm == null) {
			throw new NotFoundException("Could not find the film detail");
		} else {
			return foundFilm;
		}
	}
	
	@RequestMapping(value = "/films/{filmId}/cinemas", method = RequestMethod.GET)
	public List<Cinema> getFeasibleCinemas(@PathVariable Long filmId) {
		FilmDescription foundFilm =  this.filmManager.getFilmDetail(filmId);
		if (foundFilm == null) {
			throw new NotFoundException("Could not find the film detail");
		} else {
			return this.filmManager.getFeasibleCinemas(filmId);
		}
	}
	
	@RequestMapping(value = "/cinemas/{cinemaId}", method = RequestMethod.GET)
	public Cinema getCinemaDetail(@PathVariable Long cinemaId) {
		Cinema foundCinema = this.filmManager.getCinemaDetail(cinemaId);
		if (foundCinema == null) {
			throw new NotFoundException("Could not find the cinema detail.");
		} else {
			return foundCinema;
		}
	}
	
	@RequestMapping(value = "/cinemas/{cinemaId}/rooms", method = RequestMethod.GET)
	public List<Room> getRoomsInCinema(@PathVariable Long cinemaId) {
		if (this.filmManager.getCinemaDetail(cinemaId) == null) {
			throw new NotFoundException("Could not find the cinema detail.");
		}
		return this.filmManager.getRoomsInCinema(cinemaId);
	}
	
	@RequestMapping(value = "/rooms/{roomId}/seats", method = RequestMethod.GET)
	public List<RoomSeat> getSeatsInRoom(@PathVariable Long roomId) {
		if (this.filmManager.getRoomDetail(roomId) == null) {
			throw new NotFoundException("Could not find the room detail.");
		}
		return this.filmManager.getSeatsInRoom(roomId);
	}
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException extends RuntimeException {
	public BadRequestException(String message) {
		super(message);
	}
}

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException extends RuntimeException {
	public UnauthorizedException(String message) {
		super(message);
	}
}

@ResponseStatus(HttpStatus.FORBIDDEN)
class ForbiddenException extends RuntimeException {
	public ForbiddenException(String message) {
		super(message);
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}
}

@ResponseStatus(HttpStatus.CONFLICT)
class ConflictException extends RuntimeException {
	public ConflictException(String message) {
		super(message);
	}
}
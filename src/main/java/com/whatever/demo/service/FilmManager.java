package com.whatever.demo.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatever.demo.domain.entity.Cinema;
import com.whatever.demo.domain.entity.Film;
import com.whatever.demo.domain.entity.FilmDescription;
import com.whatever.demo.domain.entity.FilmGenres;
import com.whatever.demo.domain.entity.Room;
import com.whatever.demo.domain.entity.RoomSeat;
import com.whatever.demo.domain.repository.CinemaRepository;
import com.whatever.demo.domain.repository.FilmDescriptionRepository;
import com.whatever.demo.domain.repository.FilmRepository;
import com.whatever.demo.domain.repository.RoomRepository;
import com.whatever.demo.domain.repository.RoomSeatRepository;


@Service
public class FilmManager {

	private static final Logger log = LoggerFactory.getLogger(FilmManager.class);

	final FilmRepository filmRepo;
	final CinemaRepository cinemaRepo;
	final FilmDescriptionRepository filmDescRepo;
	final RoomRepository roomRepo;
	final RoomSeatRepository roomSeatRepo;
	
	@Autowired
	public FilmManager(
			FilmRepository filmRepo, 
			CinemaRepository cinemaRepo,
			FilmDescriptionRepository filmDescRepo,
			RoomRepository roomRepo,
			RoomSeatRepository roomSeatRepo) {
		this.filmRepo = filmRepo;
		this.cinemaRepo = cinemaRepo;
		this.filmDescRepo = filmDescRepo;
		this.roomRepo = roomRepo;
		this.roomSeatRepo = roomSeatRepo;
	}
	
	
	// just for test
	public void setup() {
		FilmDescription desc1 = this.filmDescRepo.save(new FilmDescription("十面埋伏", 120, "中国大陆", "中文", new Date(),
				"在很久很久以前。。", 7.7, "冯小刚", "/poster1.png", FilmGenres.ACTION));
		FilmDescription desc2 = this.filmDescRepo.save(new FilmDescription("卧虎藏龙", 120, "中国大陆", "中文", new Date(),
				"在很久很久以前。。", 7.8, "张艺谋", "/poster2.png", FilmGenres.ADVENTURE));
		
		Cinema cinema1 = cinemaRepo.findAll().get(0);
		this.filmRepo.save(new Film(desc1, cinema1, cinema1.getRooms().get(0), new Date(), 50));
		this.filmRepo.save(new Film(desc1, cinema1, cinema1.getRooms().get(1), new Date(), 48));
		this.filmRepo.save(new Film(desc2, cinema1, cinema1.getRooms().get(0), new Date(), 100));

		Cinema cinema2 = cinemaRepo.findAll().get(1);
		this.filmRepo.save(new Film(desc2, cinema2, cinema2.getRooms().get(0), new Date(), 100));
		
		log.info("Test - find films according to city code: " + filmDescRepo.findByCityCode(440100L).size());
		log.info("Test - find films according to city code: " + filmDescRepo.findByCityCode(000000L).size());
		log.info("Test - find cinemas for film: " + cinemaRepo.findByFilmDescId(desc1.getId()).size());
		log.info("Test - find cinemas for film: " + cinemaRepo.findByFilmDescId(desc2.getId()).size());
		log.info("Test - find rooms for cinemas: " + roomRepo.findByCinemaId(cinema1.getId()).size());
		log.info("Test - find rooms for cinemas: " + roomRepo.findByCinemaId(cinema2.getId()).size());
	}
	
	public List<FilmDescription> findByCityCode(Long cityCode) {
		return this.filmDescRepo.findByCityCode(cityCode);
	}
	
	public FilmDescription getFilmDetail(Long filmDescId) {
		return this.filmDescRepo.findOne(filmDescId);
	}
	
	public List<Cinema> getFeasibleCinemas(Long filmId) {
		return this.cinemaRepo.findByFilmDescId(filmId);
	}
	
	public Cinema getCinemaDetail(Long cinemaId) {
		return this.cinemaRepo.findOne(cinemaId);
	}
	
	public List<Room> getRoomsInCinema(Long cinemaId) {
		return roomRepo.findByCinemaId(cinemaId);
	}
	
	public Room getRoomDetail(Long roomId) {
		return this.roomRepo.findOne(roomId);
	}
	
	public List<RoomSeat> getSeatsInRoom(Long roomId) {
		return this.roomSeatRepo.findByRoomId(roomId);
	}
}

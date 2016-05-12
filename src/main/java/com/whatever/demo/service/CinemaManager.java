package com.whatever.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatever.demo.domain.entity.Cinema;
import com.whatever.demo.domain.entity.City;
import com.whatever.demo.domain.entity.District;
import com.whatever.demo.domain.entity.Location;
import com.whatever.demo.domain.entity.Room;
import com.whatever.demo.domain.entity.RoomSeat;
import com.whatever.demo.domain.repository.CinemaRepository;
import com.whatever.demo.domain.repository.CityRepository;
import com.whatever.demo.domain.repository.DistrictRepository;
import com.whatever.demo.domain.repository.LocationRepository;
import com.whatever.demo.domain.repository.RoomRepository;
import com.whatever.demo.domain.repository.RoomSeatRepository;

@Service
public class CinemaManager {
	
	private static final Logger log = LoggerFactory.getLogger(CinemaManager.class);

	final CinemaRepository cinemaRepo;
	final CityRepository cityRepo;
	final DistrictRepository districtRepo;
	final LocationRepository locationRepo;
	
	final RoomRepository roomRepo;
	final RoomSeatRepository roomSeatRepo;
	
	@Autowired
	public CinemaManager(
			CinemaRepository cinemaRepo,
			CityRepository cityRepo,
			DistrictRepository districtRepo,
			LocationRepository locationRepo,
			RoomRepository roomRepo,
			RoomSeatRepository roomSeatRepo) {
		this.cinemaRepo = cinemaRepo;
		this.cityRepo = cityRepo;
		this.districtRepo = districtRepo;
		this.locationRepo = locationRepo;
		this.roomRepo = roomRepo;
		this.roomSeatRepo = roomSeatRepo;
	}
	
	// just for test.
	public void setup() {
		City guangzhou  = this.cityRepo.save(new City("广州", "gz", 440100L));
		District tianhe = this.districtRepo.save(new District(guangzhou, "天河区", 440106L));	
		Location location1 = this.locationRepo.save(new Location(guangzhou, tianhe, "天河东路天河时尚广场xx号"));
		Location location2 = this.locationRepo.save(new Location(guangzhou, tianhe, "体育西路正佳广场xx号"));
	
		Cinema cinema1 = this.cinemaRepo.save(new Cinema(location1, "天河城影院", "电影院描述1"));
		Cinema cinema2 = this.cinemaRepo.save(new Cinema(location2, "飞扬影院（正佳店）", "电影院描述2"));	
		
		Room room1 = this.roomRepo.save(new Room(cinema1, "天河城1号厅", "巨幕3D影院！"));
		Room room2 = this.roomRepo.save(new Room(cinema1, "天河城2号厅", "IMAX影院"));
		Room room3 = this.roomRepo.save(new Room(cinema2, "飞扬影院1号厅", "普通的房间。。"));
		
		this.roomSeatRepo.save(new RoomSeat(room1, 1, 1));
		this.roomSeatRepo.save(new RoomSeat(room1, 1, 2));
		
		this.roomSeatRepo.save(new RoomSeat(room2, 1, 1));
		this.roomSeatRepo.save(new RoomSeat(room2, 1, 2));	
		
		this.roomSeatRepo.save(new RoomSeat(room3, 1, 1));
		this.roomSeatRepo.save(new RoomSeat(room3, 1, 2));
		this.roomSeatRepo.save(new RoomSeat(room3, 1, 3));
	}

}

package com.whatever.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatever.demo.domain.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	List<Room> findByCinemaId(Long cinemaId);
}

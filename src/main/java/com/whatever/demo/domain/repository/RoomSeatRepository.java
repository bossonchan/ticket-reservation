package com.whatever.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatever.demo.domain.entity.RoomSeat;

public interface RoomSeatRepository extends JpaRepository<RoomSeat, Long>{
	List<RoomSeat> findByRoomId(Long roomId);
}

package com.whatever.demo.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatever.demo.domain.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Collection<Reservation> findByOwnerUsername(String username);
}

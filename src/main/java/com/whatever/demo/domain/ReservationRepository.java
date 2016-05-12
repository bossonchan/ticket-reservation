package com.whatever.demo.domain;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Collection<Reservation> findByOwnerUsername(String username);
}

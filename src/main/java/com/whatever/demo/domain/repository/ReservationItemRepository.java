package com.whatever.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatever.demo.domain.entity.ReservationItem;

public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {

}

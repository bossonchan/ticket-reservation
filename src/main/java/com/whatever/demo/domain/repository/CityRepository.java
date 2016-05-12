package com.whatever.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatever.demo.domain.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

}

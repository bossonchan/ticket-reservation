package com.whatever.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatever.demo.domain.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}

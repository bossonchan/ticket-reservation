package com.whatever.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatever.demo.domain.entity.District;

public interface DistrictRepository extends JpaRepository<District, Long>{

}

package com.whatever.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.whatever.demo.domain.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long>{

	@Query(value = 
			  "select c from Cinema c "
			+ "left join c.films f "
			+ "left join f.filmDescription fd "
			+ "where fd.id = :filmDescId")
	List<Cinema> findByFilmDescId(@Param("filmDescId") Long filmId);
}

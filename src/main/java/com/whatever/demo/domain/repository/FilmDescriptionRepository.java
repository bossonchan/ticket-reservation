package com.whatever.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.whatever.demo.domain.entity.Film;
import com.whatever.demo.domain.entity.FilmDescription;

public interface FilmDescriptionRepository extends JpaRepository<FilmDescription, Long>{
	@Query(value = 
			  "select distinct fd from FilmDescription fd "
			+ "left join fd.films f "
			+ "left join f.cinema c "
			+ "left join c.location l "
			+ "left join l.city c "
			+ "where c.code = :code")
	List<FilmDescription> findByCityCode(@Param("code") Long code);
}

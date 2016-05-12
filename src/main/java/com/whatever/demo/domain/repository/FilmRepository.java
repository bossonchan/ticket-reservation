package com.whatever.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.whatever.demo.domain.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
}

package com.whatever.demo.domain.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.whatever.demo.domain.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByUsername(String username);
}

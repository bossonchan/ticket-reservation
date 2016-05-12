package com.whatever.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


import com.whatever.demo.domain.Reservation;
import com.whatever.demo.domain.ReservationRepository;
import com.whatever.demo.domain.UserRepository;
import com.whatever.demo.domain.User;

@Configuration
@EnableAutoConfiguration
@EnableRedisHttpSession
@ComponentScan
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	// -- session configure --
	@Bean
	public JedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}
	// -- end session configure --
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	// -- test data preparation --
	@Bean
	public CommandLineRunner prepareData(UserRepository userRepo, ReservationRepository reservationRepo) {
		return (args) -> {
			User me = userRepo.save(new User("Shin", "123123"));
			reservationRepo.save(new Reservation(me, "13580512947"));
			reservationRepo.save(new Reservation(me, "13580512948"));
			reservationRepo.save(new Reservation(me, "13580512948"));
			
			List<Reservation> reservations = (List<Reservation>) reservationRepo.findByOwnerUsername("Shin");
			Reservation reservation = reservations.get(0);
			if (reservation == null) {
				log.info("not found");
			} else {
				log.info("found: " + reservation.getOwner().getPassword());
			}
		};
	}
	// -- end test data preparation -- 
}

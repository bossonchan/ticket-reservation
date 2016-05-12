package com.whatever.demo;

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

import com.whatever.demo.service.CinemaManager;
import com.whatever.demo.service.FilmManager;

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
	public CommandLineRunner prepareData(
			FilmManager filmManager,
			CinemaManager cinemaManager) {
		return (args) -> {
			cinemaManager.setup();
			filmManager.setup();
		};
	}
	// -- end test data preparation -- 
}

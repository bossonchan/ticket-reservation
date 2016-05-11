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
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.whatever.demo.service.UserManager;
import com.whatever.demo.domain.User;

@Configuration
@EnableAutoConfiguration
@EnableRedisHttpSession
@ComponentScan
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner prepareData(UserManager userManager) {
		return (args) -> {
			log.info("kladfjadsljflasdjfklasdlflasdfj");
			userManager.register(new User("Shin", "123123"));
			userManager.register(new User("Bosson Chan", "123123"));
			userManager.register(new User("Spring Boot", "123123"));
		};
	}
}
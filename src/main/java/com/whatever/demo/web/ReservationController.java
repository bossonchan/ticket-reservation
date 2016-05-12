package com.whatever.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whatever.demo.domain.entity.Reservation;

@RestController
public class ReservationController {

	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public Reservation makeReservation(HttpServletRequest request) {
		// TODO
		return null;
		
	}
}

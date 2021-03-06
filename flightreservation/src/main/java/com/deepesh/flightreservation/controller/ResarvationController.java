package com.deepesh.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepesh.flightreservation.dto.ReservationRequest;
import com.deepesh.flightreservation.entities.Flight;
import com.deepesh.flightreservation.entities.Reservation;
import com.deepesh.flightreservation.repos.FlightRepository;
import com.deepesh.flightreservation.services.ReservationService;

@Controller
public class ResarvationController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ResarvationController.class);
	
	@Autowired
	private FlightRepository flightRepos;
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelMap) {
		LOGGER.info("showCompleteReservation()"+flightId);
		Flight flight = flightRepos.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
		
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		LOGGER.info("completeReservation()"+request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created Successfully and the id is: "+reservation.getId());
		return "reservationConfirmation";
		
	}
}

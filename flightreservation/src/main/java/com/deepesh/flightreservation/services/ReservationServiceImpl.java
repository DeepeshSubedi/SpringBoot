package com.deepesh.flightreservation.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.deepesh.flightreservation.dto.ReservationRequest;
import com.deepesh.flightreservation.entities.Flight;
import com.deepesh.flightreservation.entities.Passenger;
import com.deepesh.flightreservation.entities.Reservation;
import com.deepesh.flightreservation.repos.FlightRepository;
import com.deepesh.flightreservation.repos.PassengerRepository;
import com.deepesh.flightreservation.repos.ReservationRepository;
import com.deepesh.flightreservation.util.EmailUtil;
import com.deepesh.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Value("${com.deepesh.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	FlightRepository flightRepos;
	
	@Autowired
	PassengerRepository passengerRepos;
	
	@Autowired
	ReservationRepository reservationRepos;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("insdie bookflight()");
		
		// make payment 
		
		Long flightId = request.getFlightId();
		LOGGER.info("fetching flight for flight id"+flightId);
		Flight flight = flightRepos.findById(flightId).get();
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepos.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("saving reservation:"+reservation);
		Reservation savedReservation = reservationRepos.save(reservation);
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		LOGGER.info("generatiing itinerary)");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("sending email/iterenary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return savedReservation;
	}

}

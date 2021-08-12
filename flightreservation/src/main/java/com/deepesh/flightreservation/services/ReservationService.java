package com.deepesh.flightreservation.services;

import com.deepesh.flightreservation.dto.ReservationRequest;
import com.deepesh.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}

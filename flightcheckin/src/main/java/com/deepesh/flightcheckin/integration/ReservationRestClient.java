package com.deepesh.flightcheckin.integration;

import com.deepesh.flightcheckin.integration.dto.Reservation;
import com.deepesh.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}

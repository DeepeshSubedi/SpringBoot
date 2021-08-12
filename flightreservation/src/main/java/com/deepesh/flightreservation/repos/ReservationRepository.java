package com.deepesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepesh.flightreservation.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

package com.deepesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepesh.flightreservation.entities.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}

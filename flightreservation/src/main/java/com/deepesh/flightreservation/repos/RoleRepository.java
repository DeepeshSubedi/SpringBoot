package com.deepesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepesh.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

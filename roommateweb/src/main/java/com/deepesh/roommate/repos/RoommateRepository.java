package com.deepesh.roommate.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepesh.roommate.entities.Roommate;

public interface RoommateRepository extends JpaRepository<Roommate, Integer> {

}

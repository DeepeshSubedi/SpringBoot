package com.deepesh.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepesh.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}

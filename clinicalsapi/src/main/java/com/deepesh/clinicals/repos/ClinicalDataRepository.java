package com.deepesh.clinicals.repos;
//
//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.deepesh.clinicals.model.ClinicalData;


public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {
	
	//List<ClinicalData> findByPatientIdAndComponetNameOrderByMeasuredDateTime(int patientId, String componentName);

}

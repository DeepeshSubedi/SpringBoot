package com.deepesh.clinicals.controllers;



//import java.util.ArrayList;
//import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepesh.clinicals.dto.ClinicalDataRequest;
import com.deepesh.clinicals.model.ClinicalData;
import com.deepesh.clinicals.model.Patient;
import com.deepesh.clinicals.repos.ClinicalDataRepository;
import com.deepesh.clinicals.repos.PatientRepository;
//import com.deepesh.clinicals.util.BMICalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {
	
	private ClinicalDataRepository clinicalDataRepository;
	private PatientRepository patientRepository;
	
	ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository){
		this.clinicalDataRepository=clinicalDataRepository;
		this.patientRepository=patientRepository;
	}
	
	@RequestMapping(value= "/clinicals", method=RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		return clinicalDataRepository.save(clinicalData);
		
	}
//	@RequestMapping(value= "/clinicals/{patientId}/{componentName}", method=RequestMethod.GET)
//	public List<ClinicalData>getClinicalData(@PathVariable("patientId") int patientId,
//			@PathVariable("componentName") String componentName){
//		if(componentName.equals("bmi")) {
//			componentName="hw";
//		}
//		List<ClinicalData> clinicalData = clinicalDataRepository.findByPatientIdAndComponetNameOrderByMeasuredDateTime(patientId, componentName);
//		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
//		for (ClinicalData eachEntry : duplicateClinicalData) {
//			BMICalculator.calculateBMI(clinicalData, eachEntry);
//		}
//		
//		return clinicalData;
//		
//	}
//	

}

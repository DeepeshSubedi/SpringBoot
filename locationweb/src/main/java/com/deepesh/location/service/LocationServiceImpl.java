package com.deepesh.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepesh.location.entities.Location;
import com.deepesh.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationRepository repo;
	public Location saveLocation(Location location) {
		 
		return repo.save(location);
	}

	public Location updateLocation(Location location) {
		
		return repo.save(location);
	}

	
	public void deleteLocation(Location location) {
		repo.delete(location);
		
	}

	
	public Location getLocationById(int id) {
		
		return repo.findById(id).get() ;
	}


	public List<Location> getAllLocations() {
		
		return repo.findAll() ;
	}



}

package com.deepesh.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepesh.vendor.entities.Vendor;
import com.deepesh.vendor.repos.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository repos;

	public Vendor saveVendor(Vendor vendor) {
		
		return repos.save(vendor);
	}

	public Vendor updateVendor(Vendor vendor) {
		
		return repos.save(vendor);
	}

	public void deleteVendor(Vendor vendor) {
		repos.delete(vendor);;
		

	}

	public Vendor getVendorById(int id) {
		
		return repos.findById(id).get();
	}

	public List<Vendor> getAllVendors() {
		
		return repos.findAll();
	}

}


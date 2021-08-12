package com.deepesh.vendor.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepesh.vendor.entities.Vendor;
import com.deepesh.vendor.repos.VendorRepository;

@RestController
@RequestMapping("/vendors")
public class VendorRESTController {
	@Autowired
	VendorRepository vendorRepos;
	@GetMapping
	public List<Vendor>getvendors(){
		return vendorRepos.findAll();
	}
@PostMapping
public Vendor createVendor(@RequestBody Vendor vendor) {
	return vendorRepos.save(vendor);
}
@PutMapping
public Vendor updateVendor(@RequestBody Vendor vendor) {
	return vendorRepos.save(vendor);
}
@DeleteMapping("/{id}")
public void deleteVendor(@PathVariable("id") int id) {
	vendorRepos.deleteById(id);
}

@GetMapping("/{id}")
public Optional<Vendor> getVendor(@PathVariable("id")int id) {
	return vendorRepos.findById(id);
}
}

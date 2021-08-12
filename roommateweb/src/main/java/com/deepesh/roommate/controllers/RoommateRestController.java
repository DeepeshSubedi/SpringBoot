package com.deepesh.roommate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepesh.roommate.entities.Roommate;
import com.deepesh.roommate.repos.RoommateRepository;

@RestController
@RequestMapping("/roommates")
public class RoommateRestController {
	@Autowired
	RoommateRepository roommateRepos;
	
	@GetMapping
	public List<Roommate>getAllRoommates(){
		return roommateRepos.findAll();
	}
	@PostMapping
	public Roommate saveRoommate(@RequestBody Roommate roommate) {
		return roommateRepos.save(roommate);
	}
	@PutMapping
	public Roommate updateRoommate(@RequestBody Roommate roommate) {
		return roommateRepos.save(roommate);
	}
	@DeleteMapping("/{id}")
	public void deleteRoommate(@PathVariable("id")int id) {
		roommateRepos.deleteById(id);
	}
	
}

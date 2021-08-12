package com.deepesh.roommate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepesh.roommate.entities.Roommate;
import com.deepesh.roommate.repos.RoommateRepository;

@Service
public class RoommateServiceImpl implements RoommateService {
	@Autowired
	private RoommateRepository repos;

	@Override
	public Roommate saveRoommate(Roommate roommate) {
		
		return repos.save(roommate);
	}

	@Override
	public Roommate updateRoommate(Roommate roommate) {
		
		return repos.save(roommate);
	}

	@Override
	public void deleteRoommate(Roommate roomate) {
		repos.delete(roomate);

	}

	@Override
	public Roommate getRoommateById(int id) {
		
		return repos.getById(id);
	}

	@Override
	public List<Roommate> getAllRoommate() {
		
		return repos.findAll();
	}

}

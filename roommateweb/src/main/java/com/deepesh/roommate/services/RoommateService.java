package com.deepesh.roommate.services;

import java.util.List;



import com.deepesh.roommate.entities.Roommate;


public interface RoommateService {
	 Roommate saveRoommate(Roommate roommate);
	 Roommate updateRoommate(Roommate roommate);
	 void deleteRoommate(Roommate roomate);
	 Roommate getRoommateById(int id);
	 List<Roommate>getAllRoommate();
	
	

}

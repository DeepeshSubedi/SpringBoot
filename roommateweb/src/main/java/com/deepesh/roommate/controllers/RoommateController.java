package com.deepesh.roommate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepesh.roommate.entities.Roommate;
import com.deepesh.roommate.repos.RoommateRepository;
import com.deepesh.roommate.services.RoommateService;
import com.deepesh.roommate.util.EmailUtil;


@Controller
public class RoommateController {
	
	@Autowired
	RoommateService service;
	@Autowired
	RoommateRepository repos;
	@Autowired
	EmailUtil emailUtil;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createRoommate";
	}
	@RequestMapping("/saveRoom")
	public String saveRoommate(@ModelAttribute("roommate") Roommate roommate, ModelMap modelMap) {
		Roommate savedRoommate = service.saveRoommate(roommate);
		String msg="The info provided has been saved with id: "+savedRoommate.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("dsubedi1130@gmail.com", "Roommate Saved", "Roommate saved successfuly.");
		return "createRoommate";
	}
	@RequestMapping("/displayRoommates")
	public String displayRoommates(ModelMap modelMap) {
		List<Roommate> allRoommates = service.getAllRoommate();
		modelMap.addAttribute("allRoommates", allRoommates);
		return "displayRoommates";
	}
	@RequestMapping("/deleteRoommate")
	public String deleteRoommate(@RequestParam("id") int id, ModelMap modelMap) {
		Roommate roommate=new Roommate();
		roommate.setId(id);
		service.deleteRoommate(roommate);
		List<Roommate> allRoommates = service.getAllRoommate();
		modelMap.addAttribute("allRoommates", allRoommates);
		return "displayRoommates";
		
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Roommate roommate = service.getRoommateById(id);
		modelMap.addAttribute("roommate", roommate);
		return "updateRoommate";
	}
	@RequestMapping("/updateRoom")
	public String updateRoommate(@ModelAttribute("roommate") Roommate roommate, ModelMap modelMap) {
		service.updateRoommate(roommate);
		List<Roommate> allRoommates = service.getAllRoommate();
		modelMap.addAttribute("allRoommates", allRoommates);
		emailUtil.sendEmail("dsubedi1130@gmail.com", "Roommmate Saved", "Roommate updated successfuly.");
		return "displayRoommates";
	}

}

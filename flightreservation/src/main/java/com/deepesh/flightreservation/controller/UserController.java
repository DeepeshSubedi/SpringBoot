package com.deepesh.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepesh.flightreservation.entities.User;
import com.deepesh.flightreservation.repos.UserRepository;
import com.deepesh.flightreservation.services.SecurityService;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepos;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(UserController.class);
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}
	@RequestMapping(value="registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute("user")User user) {
		LOGGER.info("Inside register()"+user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepos.save(user);
		return "login/login";
		
	}
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email")String email,@RequestParam("password") String password,ModelMap modelMap) {
		LOGGER.info("Inside login()"+email);

		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg", "invalid username or password.please try again");
		}
		return "login/login";
	}

}

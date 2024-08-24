package com.foodiee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodiee.dto.UserDto;
import com.foodiee.service.UserService;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String check() {
		return "Yes i am working fine";
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> insertUser(@RequestBody UserDto userDto){
		userService.createUser(userDto);
		return new ResponseEntity<>("User registered.",HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<String> getPassword(@RequestBody UserDto userDto){
		
		String password = userService.getPasswordByEmail(userDto.getEmail());
		
		if(password == null) {
			return new ResponseEntity<>("email",HttpStatus.OK);
		} else if(userDto.getPassword().equals(password)) {
			return new ResponseEntity<>("granted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("password",HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/isExcists")
	public ResponseEntity<Boolean> eamilOrPhoneExcists(@RequestBody UserDto userDto){
		
		Boolean isExcists = userService.existsByEmailOrPhone(userDto.getEmail(), userDto.getPhone());
		
		return new ResponseEntity<>(isExcists,HttpStatus.OK);
	}
	
	

}

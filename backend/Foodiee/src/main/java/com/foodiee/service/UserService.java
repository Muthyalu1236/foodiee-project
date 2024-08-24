package com.foodiee.service;

import com.foodiee.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	String getPasswordByEmail(String email);
	
	boolean existsByEmailOrPhone(String email, Long phone);

}

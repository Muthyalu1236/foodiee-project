package com.foodiee.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodiee.dao.User;
import com.foodiee.dto.UserDto;
import com.foodiee.mapper.UserMapper;
import com.foodiee.repository.UserRepository;
import com.foodiee.service.UserService;

@Service
public class ServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = UserMapper.mapToUser(userDto);
		userRepo.save(user);
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public String getPasswordByEmail(String email) {
		User user = userRepo.findByEmail(email);
		if(user != null) {
			return user.getPassword();
		} else {
			return null;
		}
	}

	@Override
	public boolean existsByEmailOrPhone(String email, Long phone) {
		return userRepo.existsByEmail(email) || userRepo.existsByPhone(phone);
	}

//	@Override
//	public boolean emailOrPhoneExcists(String email, Long phone) {
//		List<User> user = userRepo.findByEmailOrPhone(email, phone);
//		
//		if(user == null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	

}

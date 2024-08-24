package com.foodiee.mapper;

import com.foodiee.dao.User;
import com.foodiee.dto.UserDto;

public class UserMapper {
	
	public static UserDto mapToUserDto(User user) {
		return new UserDto(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getPassword(),
				user.getPhone()
				);
	}
	
	public static User mapToUser(UserDto userDto) {
		return new User(
				userDto.getId(),
				userDto.getName(),
				userDto.getEmail(),
				userDto.getPassword(),
				userDto.getPhone()
				);
	}

}

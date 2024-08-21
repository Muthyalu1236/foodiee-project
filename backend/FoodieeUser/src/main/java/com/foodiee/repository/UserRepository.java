package com.foodiee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodiee.dao.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
//	List<User> findByEmailOrPhone(String email, Long phone);
	
	boolean existsByEmail(String email);

    boolean existsByPhone(Long phone);

}
